package com.example.chapter3.homework;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class mFragmentPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mlist;



        public mFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mlist = list;
        }
        @Override
        public Fragment getItem(int position) {
            return mlist.get(position);
        }
        @Override
        public int getCount() {
            return mlist.size();
        }
    }
