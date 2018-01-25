package com.example.bobobox.bobobox.Fragments;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.bobobox.bobobox.R;

/**
 * Created by Unknown on 12/24/2017.
 */

public class FragmentControlBox extends Fragment implements View.OnClickListener {

    LinearLayout doorControl, lightControl;

    Fragment fragment = null;
    FragmentTransaction transaction = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_control_box, container, false);
        initialVariable(v);

        doorControl.setOnClickListener(this);
        lightControl.setOnClickListener(this);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Fragment fragment = new FragmentDoorControl();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentCBRoom, fragment).commit();
    }

    public void initialVariable(View v){
        doorControl = (LinearLayout) v.findViewById(R.id.boboboxCBDoorControlLL);
        lightControl = (LinearLayout) v.findViewById(R.id.boboboxCBLightControlLL);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boboboxCBDoorControlLL:
                fragment = new FragmentDoorControl();
                transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentCBRoom, fragment).commit();
                break;
            case R.id.boboboxCBLightControlLL:
                fragment = new FragmentLightControl();
                transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentCBRoom, fragment).commit();
                break;
            default:
                break;
        }

    }
}
