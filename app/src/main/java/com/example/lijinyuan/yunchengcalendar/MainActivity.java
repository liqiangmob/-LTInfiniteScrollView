package com.example.lijinyuan.yunchengcalendar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<Calendar> list;
    private MyPager viewPager;
    private PageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add(new Calendar("12%", "排卵期", "排卵期1", "21%"));
        list.add(new Calendar("13%", "排卵期", "排卵期2", "22%"));
        list.add(new Calendar("14%", "排卵期", "排卵期3", "23%"));
        list.add(new Calendar("15%", "排卵期", "排卵期4", "24%"));
        list.add(new Calendar("16%", "排卵期", "排卵期5", "25%"));
        list.add(new Calendar("17%", "排卵期", "排卵期6", "26%"));
        list.add(new Calendar("18%", "排卵期", "排卵期7", "27%"));
        list.add(new Calendar("19%", "排卵期", "排卵期8", "28%"));
        list.add(new Calendar("11%", "排卵期", "排卵期1", "29%"));
        list.add(new Calendar("21%", "排卵期", "排卵期2", "21%"));
        list.add(new Calendar("31%", "排卵期", "排卵期3", "31%"));
        list.add(new Calendar("41%", "排卵期", "排卵期4", "41%"));
        list.add(new Calendar("51%", "排卵期", "排卵期6", "51%"));
        list.add(new Calendar("61%", "排卵期", "排卵期7", "61%"));
        list.add(new Calendar("71%", "排卵期", "排卵期8", "71%"));
        list.add(new Calendar("81%", "排卵期", "排卵期9", "81%"));
        list.add(new Calendar("91%", "排卵期", "排卵期0", "91%"));
        list.add(new Calendar("11%", "排卵期", "排卵期q", "21%"));
        list.add(new Calendar("11%", "排卵期", "排卵期a", "21%"));
        list.add(new Calendar("11%", "排卵期", "排卵期3", "21%"));


        init();

    }

    private void init() {
        viewPager = (MyPager) findViewById(R.id.view_pager);
        adapter = new PageAdapter(MainActivity.this, list);
        viewPager.setOffscreenPageLimit(5);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0)
                    viewPager.setCurrentItem(position + 1);
                else if (position == list.size() - 1)
                    viewPager.setCurrentItem(position - 1);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
