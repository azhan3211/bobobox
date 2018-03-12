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

public class FragmentBookingHistory extends Fragment {
    RecyclerView ticketHistory;
    RecyclerView.Adapter adapter;
    List<MyBookingList> myBookingLists;

    public FragmentBookingHistory() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking_history, container, false);
        initialVariable(view);
        return view;
    }

    public void initialVariable(View view){
        ticketHistory = (RecyclerView) view.findViewById(R.id.boboboxMBHistoryRV);
        ticketHistory.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        myBookingLists = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            MyBookingList myBookingList = new MyBookingList(
                    "Bobobox Name History",
                    "Bobobox Type",
                    "21 sep 2017",
                    "22 sep 2017"
            );
            myBookingLists.add(myBookingList);
        }
        adapter = new MyBookingAdapter(myBookingLists, getActivity().getApplicationContext());
        ticketHistory.setAdapter(adapter);
    }


}
