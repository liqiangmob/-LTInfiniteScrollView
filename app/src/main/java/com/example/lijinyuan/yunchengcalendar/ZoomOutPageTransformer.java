package com.example.lijinyuan.yunchengcalendar;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by leo on 16/5/7.
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.9f;
    private static float defaultScale = 0.9f;
    private float defaultRotation = 720f;
    private float flipCycle = 0.25f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setScaleX(defaultScale);
            view.setScaleY(defaultScale);
        } else if (position <= 1) {
            if (position < flipCycle && position > -flipCycle) {
                float rotation = defaultRotation * position;
                float scale = 1 - Math.abs(position * 3);
                view.setScaleX(scale);
                view.setScaleY(scale);
                view.setRotationY(rotation);
//                view.findViewById(R.id.it_day_number).setVisibility(View.VISIBLE);
            } else {
                // [-1,1]
                // Modify the default slide transition to shrink the page as well
                view.setRotationY(0);
//                view.findViewById(R.id.it_day_number).setVisibility(View.GONE);
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                int paddingTop = (int) (30 * Math.abs(position));
                if (position < 0) {
                    view.setTranslationX(horzMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin / 2);
                }

                view.setTranslationY(-paddingTop);
                view.setScaleX(flipCycle);
                view.setScaleY(flipCycle);
                // Scale the page down (between MIN_SCALE and 1)
            }
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setScaleX(defaultScale);
            view.setScaleY(defaultScale);
        }


    }

}
