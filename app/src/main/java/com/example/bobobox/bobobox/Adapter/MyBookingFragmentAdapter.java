package com.example.bobobox.bobobox.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.bobobox.bobobox.Fragments.FragmentBookingActive;
import com.example.bobobox.bobobox.Fragments.FragmentBookingHistory;

/**
 * Created by Unknown on 3/6/2018.
 */

public class MyBookingFragmentAdapter extends FragmentPagerAdapter {
    int tabCount;
    public MyBookingFragmentAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentBookingActive();
            case 1:
                return new FragmentBookingHistory();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
