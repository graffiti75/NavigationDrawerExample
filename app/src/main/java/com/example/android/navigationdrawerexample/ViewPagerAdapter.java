package com.example.android.navigationdrawerexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    //--------------------------------------------------
    // Fragment Pager Adapter
    //--------------------------------------------------

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }
}