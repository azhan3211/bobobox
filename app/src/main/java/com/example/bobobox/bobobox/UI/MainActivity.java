package com.example.bobobox.bobobox.UI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;


import com.example.bobobox.bobobox.Data.SharedPreference;
import com.example.bobobox.bobobox.Fragments.FragmentSetting;
import com.example.bobobox.bobobox.Fragments.FragmentMyProfil;
import com.example.bobobox.bobobox.Fragments.FragmentHome;
import com.example.bobobox.bobobox.Fragments.FragmentControlBox;
import com.example.bobobox.bobobox.Fragments.FragmentMyBooking;
import com.example.bobobox.bobobox.R;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private RelativeLayout relativeLayout;
    private Fragment fragment = null;

    private FragmentManager fm = getSupportFragmentManager();
    private FragmentTransaction ft = fm.beginTransaction();

    private SharedPreference sharedPreference = new SharedPreference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreference.removeAllValue(MainActivity.this);

//        relativeLayout = (RelativeLayout) findViewById(R.id.fragmentContainer);

        tabLayout = (TabLayout) findViewById(R.id.tabs); // get the reference of TabLayout

        initialTab();

        fragment = new FragmentHome();

        ft.add(R.id.fragmentContainer, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // get the current selected tab's position and replace the fragment accordingly
                tab.getIcon().setColorFilter(Color.parseColor("#06A098"), PorterDuff.Mode.SRC_IN);
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new FragmentHome();
                        break;
                    case 1:
                        fragment = new FragmentMyBooking();
                        break;
                    case 2:
                        fragment = new FragmentControlBox();
                        break;
                    case 3:
                        fragment = new FragmentMyProfil();
                        break;
                    case 4:
                        fragment = new FragmentSetting();
                        break;
                }
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragmentContainer, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#a9a9a9"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        sharedPreference.removeAllValue(MainActivity.this);
        Intent intent = getIntent();
        intent.replaceExtras(new Bundle());
        intent.setAction("");
        intent.setData(null);
        intent.setFlags(0);
    }

    private void initialTab(){
        TabLayout.Tab firstTab = tabLayout.newTab(); // Create a new Tab names
        firstTab.setText("Home"); // set the Text for the first Tab
        firstTab.setIcon(R.drawable.ic_home);
        tabLayout.addTab(firstTab, true);

        TabLayout.Tab secondTab = tabLayout.newTab(); // Create a new Tab names "First Tab"
        secondTab.setText("My Booking"); // set the Text for the first Tab
        secondTab.setIcon(R.drawable.ic_booking);
        tabLayout.addTab(secondTab); // add  the tab to the TabLayout

        TabLayout.Tab thirdTab = tabLayout.newTab(); // Create a new Tab names "First Tab"
        thirdTab.setText("Control Box"); // set the Text for the first Tab
        thirdTab.setIcon(R.drawable.ic_control);
        tabLayout.addTab(thirdTab); // add  the tab to the TabLayout

        TabLayout.Tab fourthTab = tabLayout.newTab(); // Create a new Tab names "First Tab"
        fourthTab.setText("My Profil"); // set the Text for the first Tab
        fourthTab.setIcon(R.drawable.ic_profil);
        tabLayout.addTab(fourthTab); // add  the tab to the TabLayout

        TabLayout.Tab fifthTab = tabLayout.newTab(); // Create a new Tab names "First Tab"
        fifthTab.setText("Setting"); // set the Text for the first Tab
        fifthTab.setIcon(R.drawable.ic_setting);
        tabLayout.addTab(fifthTab); // add  the tab to the TabLayout
    }
}
