package com.example.bobobox.bobobox.Fragments;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.example.bobobox.bobobox.Adapter.MyBookingFragmentAdapter;
import com.example.bobobox.bobobox.R;

/**
 * Created by Unknown on 12/24/2017.
 */

public class FragmentMyBooking extends Fragment {
    LinearLayout activeBooking;
    LinearLayout historyBooking;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_booking, container, false);
        initialVariable(v);
        tabSetup();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    }

    private void initialVariable(View v) {
        tabLayout = (TabLayout) v.findViewById(R.id.tabMyBooking);
        viewPager = (ViewPager) v.findViewById(R.id.mybookingVP);
    }

    private void tabSetup(){
        final TabLayout.Tab tabActive = tabLayout.newTab();
        tabActive.setText("Active");
        tabLayout.addTab(tabActive, true);

        final TabLayout.Tab tabHistory = tabLayout.newTab();
        tabHistory.setText("History");
        tabLayout.addTab(tabHistory);

        MyBookingFragmentAdapter adapter = new MyBookingFragmentAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0)
                    tabActive.select();
                if(position == 1)
                    tabHistory.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
