package com.example.bobobox.bobobox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.bobobox.bobobox.Adapter.ViewPagerAdapter;
import com.example.bobobox.bobobox.Fragments.FragmentAbout;
import com.example.bobobox.bobobox.Fragments.FragmentMapLocation;
import com.example.bobobox.bobobox.Fragments.FragmentReview;

/**
 * Created by unknown on 31/12/17.
 */

public class DetailRoom extends AppCompatActivity {

    private FragmentManager fm = getSupportFragmentManager();
    private FragmentTransaction ft = fm.beginTransaction();
    private Fragment fragment = null;

    private ImageView boboboxMusic, boboboxTv, boboboxWifi, boboboxTransportation, boboboxHotel;

    private TabLayout tabLayout;

    ViewPager viewPager;
    LinearLayout boboboxImageSliderLL;
    private int dotsCount;
    private ImageView[] dots;

    Button booking;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_room_layout);

        viewPager = (ViewPager) findViewById(R.id.boboboxImageSlideVP);
        booking = (Button) findViewById(R.id.boboboxDRBookingBtn);

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailRoom.this, BookingConfirmationStep1.class);
                startActivity(intent);
            }
        });

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        boboboxImageSliderLL = (LinearLayout) findViewById(R.id.boboboxDotImageSliderLL);

        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for(int i = 0; i < dotsCount; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8,0,8,0);

            boboboxImageSliderLL.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i < dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabDetail);

        boboboxMusic = (ImageView) findViewById(R.id.boboboxMusicFacility);
        boboboxTv = (ImageView) findViewById(R.id.boboboxTvCableFacility);
        boboboxWifi = (ImageView) findViewById(R.id.boboboxWifiFacility);
        boboboxTransportation = (ImageView) findViewById(R.id.boboboxTransportationFacility);
        boboboxHotel = (ImageView) findViewById(R.id.boboboxHotelInfoFacility);

        initialTab();

        fragment = new FragmentAbout();
        ft.add(R.id.boboboxFragmentDetail, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0 :
                        fragment = new FragmentAbout();
                        break;
                    case 1 :
                        fragment = new FragmentReview();
                        break;
                    case 2 :
                        fragment = new FragmentMapLocation();
                        break;
                }

                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.boboboxFragmentDetail, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void initialTab(){
        TabLayout.Tab firstTab = tabLayout.newTab(); // Create a new Tab names
        firstTab.setText("About"); // set the Text for the first Tab
        tabLayout.addTab(firstTab, true);

        TabLayout.Tab secondTab = tabLayout.newTab(); // Create a new Tab names "First Tab"
        secondTab.setText("Review"); // set the Text for the first Tab
        tabLayout.addTab(secondTab); // add  the tab to the TabLayout

        TabLayout.Tab thirdTab = tabLayout.newTab(); // Create a new Tab names "First Tab"
        thirdTab.setText("Map Location"); // set the Text for the first Tab
        tabLayout.addTab(thirdTab); // add  the tab to the TabLayout
    }
}
