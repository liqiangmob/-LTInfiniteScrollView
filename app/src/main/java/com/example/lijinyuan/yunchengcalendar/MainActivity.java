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
        list.add(new Calendar("12%", "镇魂街", "镇魂街", "21%"));
        list.add(new Calendar("13%", "镇魂街", "镇魂街", "22%"));
        list.add(new Calendar("14%", "镇魂街", "镇魂街", "23%"));
        list.add(new Calendar("15%", "镇魂街", "镇魂街", "24%"));
        list.add(new Calendar("16%", "镇魂街", "镇魂街", "25%"));
        list.add(new Calendar("17%", "镇魂街", "镇魂街", "26%"));
        list.add(new Calendar("18%", "镇魂街", "镇魂街", "27%"));
        list.add(new Calendar("19%", "镇魂街", "镇魂街", "28%"));
        list.add(new Calendar("11%", "镇魂街", "镇魂街", "29%"));
        list.add(new Calendar("21%", "镇魂街", "镇魂街", "21%"));
        list.add(new Calendar("31%", "镇魂街", "镇魂街", "31%"));
        list.add(new Calendar("41%", "镇魂街", "镇魂街", "41%"));
        list.add(new Calendar("51%", "镇魂街", "镇魂街", "51%"));
        list.add(new Calendar("61%", "镇魂街", "镇魂街", "61%"));
        list.add(new Calendar("71%", "镇魂街", "镇魂街", "71%"));
        list.add(new Calendar("81%", "镇魂街", "镇魂街", "81%"));
        list.add(new Calendar("91%", "镇魂街", "镇魂街", "91%"));
        list.add(new Calendar("11%", "镇魂街", "镇魂街", "21%"));
        list.add(new Calendar("11%", "镇魂街", "镇魂街", "21%"));
        list.add(new Calendar("11%", "镇魂街", "镇魂街", "21%"));


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
