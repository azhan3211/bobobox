package com.example.bobobox.bobobox.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bobobox.bobobox.Adapter.MyBookingAdapter;
import com.example.bobobox.bobobox.Data.MyBookingList;
import com.example.bobobox.bobobox.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Unknown on 3/6/2018.
 */

public class FragmentBookingActive extends Fragment {

    private RecyclerView ticketActiveRV;
    private RecyclerView.Adapter adapter;
    private List<MyBookingList> bookingActiveLists;
    MyBookingList bookingActiveList;

    public FragmentBookingActive() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking_active, container, false);
        initialVariable(view);
        return view;
    }

    private void initialVariable(View view) {
        ticketActiveRV = (RecyclerView) view.findViewById(R.id.boboboxMBActiveRV);
        ticketActiveRV.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        bookingActiveLists = new ArrayList<>();
        int i;
        for(i = 0; i < 3; i++){
            bookingActiveList = new MyBookingList(
                    "Bobobox Name Active",
                    "Bobobox Type",
                    "21 sep 2017",
                    "22 sep 2017"
            );
            bookingActiveLists.add(bookingActiveList);
        }
        adapter = new MyBookingAdapter(bookingActiveLists, getActivity().getApplicationContext());
        ticketActiveRV.setAdapter(adapter);
    }
}
