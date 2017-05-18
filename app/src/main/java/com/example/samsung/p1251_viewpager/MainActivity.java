package com.example.samsung.p1251_viewpager;

import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.support.v4.view.ViewPager.*;

public class MainActivity extends FragmentActivity {

    private static final int PAGE_COUNT = 10;
    private ViewPager vpMain;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpMain = (ViewPager) findViewById(R.id.vpMain);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        vpMain.setAdapter(pagerAdapter);

        vpMain.setOnPageChangeListener(new OnPageChangeListener() {

            String message;

            @Override
            public void onPageSelected(int position) {
                message = "MainActivity onCreate().setOnPageChangeListener().onPageSelected(),\n"
                        + "position = " + position;
                Messager.sendToAllRecipients(getBaseContext(), message);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                message = "MainActivity onCreate().setOnPageChangeListener().onPageScrolled(),\n"
                        + "position = " + position
                        + ",\npositionOffset = " + positionOffset
                        + ",\npositionOffsetPixels = " + positionOffsetPixels;
                Messager.sendToAllRecipients(getBaseContext(), message);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                message = "MainActivity onCreate().setOnPageChangeListener().onPageScrollStateChanged(),\n"
                        + "state = " + state;
                Messager.sendToAllRecipients(getBaseContext(), message);
            }
        });
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }
}
