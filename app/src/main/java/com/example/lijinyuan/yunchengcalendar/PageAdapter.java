package com.example.lijinyuan.yunchengcalendar;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PageAdapter extends PagerAdapter {
    private ArrayList<Calendar> calendars;
    private Context context;
    private AnimatorSet mRightOutSet; // 右出动画
    private AnimatorSet mLeftInSet; // 左入动画
    private boolean mIsShowBack;

    boolean dayShow = true;
    Handler handler = new Handler();
    List<View> list = new ArrayList<>();

    public PageAdapter(Context context, ArrayList<Calendar> calendars) {
        this.context = context;
        this.calendars = calendars;
    }

    @Override
    public int getCount() {
        return calendars.size();
    }


    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_view, null);
        list.add(view);
        view.setTag(position);
        TextView it_day_number = (TextView) view.findViewById(R.id.it_day_number);
        final TextView it_day_title = (TextView) view.findViewById(R.id.it_day_title);
        TextView it_day_state = (TextView) view.findViewById(R.id.it_day_state);
        final LinearLayout it_day_linearLayout = (LinearLayout) view.findViewById(R.id.it_day_linearLayout);
        RoundProgressBar roundProgressBar = (RoundProgressBar) view.findViewById(R.id.roundProgressBar);

        TextView it_percent_number = (TextView) view.findViewById(R.id.it_percent_number);
        final TextView it_percent_title = (TextView) view.findViewById(R.id.it_percent_title);
        TextView it_percent_state = (TextView) view.findViewById(R.id.it_percent_state);
        final LinearLayout it_percent_linearLayout = (LinearLayout) view.findViewById(R.id.it_percent_linearLayout);
        RoundProgressBar per_proundProgressBar = (RoundProgressBar) view.findViewById(R.id.per_proundProgressBar);
        it_day_number.setTag(calendars.get(position).getNumber());
        it_day_title.setTag(calendars.get(position).getTitle());
        it_day_state.setTag(calendars.get(position).getState());

        it_percent_number.setTag(calendars.get(position).getPercent());
        it_percent_title.setTag(calendars.get(position).getTitle());
        it_percent_state.setTag(calendars.get(position).getState());

        final FrameLayout mFlContainer = (FrameLayout) view.findViewById(R.id.main_fl_container);
        final FrameLayout mFlCardBack = (FrameLayout) view.findViewById(R.id.main_fl_card_back);
        final FrameLayout mFlCardFront = (FrameLayout) view.findViewById(R.id.main_fl_card_front);
        mRightOutSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.anim_out);
        mLeftInSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.anim_in);

        // 设置点击事件
        mRightOutSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mFlContainer.setClickable(false);
            }
        });
        mLeftInSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mFlContainer.setClickable(true);
            }
        });
        int distance = 16000;
        float scale = context.getResources().getDisplayMetrics().density * distance;
        mFlCardFront.setCameraDistance(scale);
        mFlCardBack.setCameraDistance(scale);

        if (view.getRight() + view.getWidth() / 2 == container.getWidth() / 2) {
            mFlContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!mIsShowBack) {
                        mRightOutSet.setTarget(mFlCardFront);
                        mLeftInSet.setTarget(mFlCardBack);
                        mRightOutSet.start();
                        mLeftInSet.start();
                        mIsShowBack = true;
                    } else { // 背面朝上
                        mRightOutSet.setTarget(mFlCardBack);
                        mLeftInSet.setTarget(mFlCardFront);
                        mRightOutSet.start();
                        mLeftInSet.start();
                        mIsShowBack = false;
                    }
                }
            });
        }
        container.addView(view);
        return view;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public float getPageWidth(int position) {
        return (float) 0.3;
    }


}
