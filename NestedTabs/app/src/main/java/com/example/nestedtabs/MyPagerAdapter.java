package com.example.nestedtabs;

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
                TabOneFragment tabOneFragment = new TabOneFragment();
                return tabOneFragment;

            case 1:
                TabTwoFragment tabTwoFragment = new TabTwoFragment();
                return tabTwoFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCounts;
    }
}
