package com.example.lijinyuan.yunchengcalendar;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by lijinyuan on 16/5/9.
 */
public class MyPager extends ViewPager {

    public MyPager(Context context) {
        super(context);
    }

    public MyPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        canvas.save();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        int h_screen = dm.heightPixels;
        child.setTranslationX(DisplayUtil.dip2px(getContext().getApplicationContext(), w_screen / 8));
        //目前720的 是192左右。。。1080的是240左右。。2K的是340左右
        boolean r = super.drawChild(canvas, child, drawingTime);
        canvas.restore();
        return r;
    }


}
