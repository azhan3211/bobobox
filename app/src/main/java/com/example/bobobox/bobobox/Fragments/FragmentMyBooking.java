package com.example.bobobox.bobobox.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.bobobox.bobobox.ActiveBooking;
import com.example.bobobox.bobobox.HistoryBooking;
import com.example.bobobox.bobobox.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Unknown on 12/24/2017.
 */

public class FragmentMyBooking extends Fragment implements View.OnClickListener {
    LinearLayout activeBooking;
    LinearLayout historyBooking;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_booking, container, false);
        initialVariable(v);
        activeBooking.setOnClickListener(this);
        historyBooking.setOnClickListener(this);
        return v;
    }

    private void initialVariable(View v) {
        activeBooking = (LinearLayout) v.findViewById(R.id.boboboxMBActiveLL);
        historyBooking = (LinearLayout) v.findViewById(R.id.boboboxMBHistoryLL);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.boboboxMBActiveLL:
                intent = new Intent(getContext(), ActiveBooking.class);
                break;
            case R.id.boboboxMBHistoryLL:
                intent = new Intent(getContext(), HistoryBooking.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
