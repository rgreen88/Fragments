package com.example.android.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rynel on 2/7/2018.
 */

public class SectionsFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    //list for fragments... look into ListFragment
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<String>(); //dont really need... just keeping track of similar named frags

    public SectionsFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //adding fragment to app and retrieving title from each fragment
    private void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
