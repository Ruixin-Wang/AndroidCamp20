package com.example.chapter3.homework;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {
    private List<Fragment> list;
    private ViewPager viewPager;
    private mFragmentPagerAdapter Adapter;

    private TabLayout mTabLayout;
    private final int[] TAB_TITLES = new int[]{R.string.HELLO0,R.string.HELLO1,R.string.HELLO2};
    private final Fragment[] TAB_FRAGMENTS = new Fragment[] {new Fragment1(),new Fragment2(),new Fragment3()};
    private final int COUNT = TAB_TITLES.length;



    private PlaceholderFragmentContact mPlaceholderFragmentContact;
    private PlaceholderFragmentMessages mPlaceholderFragmentMessages;
    private PlaceholderFragmentTweets mPlaceholderFragmentTweets;





    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_ch3ex3);



        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面
        list = new ArrayList<>();
        list.add(new PlaceholderFragmentMessages());
        list.add(new PlaceholderFragmentContact());
        list.add(new PlaceholderFragmentTweets());
        Adapter = new mFragmentPagerAdapter(getSupportFragmentManager(), list);
        viewPager = (ViewPager) findViewById(R.id.viewpages);
        viewPager.setAdapter(Adapter);
        viewPager.setCurrentItem(0);



        // TODO: ex3-2, 添加 TabLayout 支持 Tab
        mTabLayout = (TabLayout)findViewById(R.id.tablayout);
        for (int i = 0; i < TAB_TITLES.length; i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            View view = this.getLayoutInflater().inflate(R.layout.tab,null);
            tab.setCustomView(view);

            TextView tvTitle = (TextView)view.findViewById(R.id.tv_tab);
            tvTitle.setText(TAB_TITLES[i]);
            mTabLayout.addTab(tab);
        }
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));


    }


}

