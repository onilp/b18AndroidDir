package com.example.tablayoutproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    int tabCounts;

    public MyPagerAdapter(FragmentManager fm, int tabCounts) {
        super(fm);
        this.tabCounts = tabCounts;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TabFragmentOne tabFragmentOne = new TabFragmentOne();
                return tabFragmentOne;

            case 1:
                TabFragmentTwo tabFragmentTwo = new TabFragmentTwo();
                return tabFragmentTwo;

            case 2:
                TabFragmentThree tabFragmentThree = new TabFragmentThree();
                return tabFragmentThree;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCounts;
    }
}
