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
public class FlipViewPager extends ViewPager {

    DisplayMetrics dm;

    public FlipViewPager(Context context) {
        super(context);
    }

    public FlipViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        canvas.save();
        DisplayMetrics dm = getResources().getDisplayMetrics();


        int screenWidth;
        int screenHeight;
//        Log.e("  DisplayMetrics", "xdpi=" + xdpi + "; ydpi=" + ydpi);
//        Log.e("  DisplayMetrics", "density=" + density + "; densityDPI=" + densityDPI);
        screenWidth = dm.widthPixels;      // 屏幕宽（像素，如：480px）
        screenHeight = dm.heightPixels;     // 屏幕高（像素，如：800px）
//        Log.e("  DisplayMetrics", "screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);

        child.setTranslationX((float) (0.4174 * screenWidth - 3.2152));
        ///像素单位，
        boolean r = super.drawChild(canvas, child, drawingTime);
        canvas.restore();
        return r;
    }


}
