package com.example.junaid.inshorts.adapters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.junaid.inshorts.SlidingFragment;

/**
 * Created by junaid on 28/01/16.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 2;

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        SlidingFragment slidingFragment = new SlidingFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        slidingFragment.setArguments(bundle);
        return slidingFragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}