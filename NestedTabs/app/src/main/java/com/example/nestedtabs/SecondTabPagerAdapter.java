package com.example.nestedtabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SecondTabPagerAdapter extends FragmentStatePagerAdapter {
    int tabCounts;

    public SecondTabPagerAdapter(FragmentManager fm, int tabCounts) {
        super(fm);
        this.tabCounts = tabCounts;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SubTabOneFragment subTabOneFragment = new SubTabOneFragment();
                return subTabOneFragment;

            case 1:
                SubTabTwoFragment subTabTwoFragment = new SubTabTwoFragment();
                return subTabTwoFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCounts;
    }
}
