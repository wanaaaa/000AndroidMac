package com.ga.android.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by alanjcaceres on 7/19/16.
 */

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    int mPageCount;

    public SectionsPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            //Complete this
            case 0:
                return new HomeFragment();
            case 1:
                return new WomansFragment();
            case 2:
                return new ContactFragment();
            default: return new HomeFragment();
        }

    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return mPageCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            default:
            case 0:
                return "Home";
            case 1:
                return "Woman's Cloth";
            case 2:
                return "Shopping Cart";
        }

    }
}
