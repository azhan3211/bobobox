package com.example.bobobox.bobobox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bobobox.bobobox.Adapter.MyBookingAdapter;
import com.example.bobobox.bobobox.Data.MyBookingList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Unknown on 1/17/2018.
 */

public class HistoryBooking extends AppCompatActivity{

    private RecyclerView.Adapter adapter;

    private RecyclerView ticketHistoryRV;
    private List<MyBookingList> bookingHistoryLists;
    MyBookingList bookingHistoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_booking);
        initialVariable();
    }

    private void initialVariable() {
        int i;
        ticketHistoryRV = (RecyclerView) findViewById(R.id.boboboxMBHistoryRV);
        ticketHistoryRV.setLayoutManager(new LinearLayoutManager(this));
        bookingHistoryLists = new ArrayList<>();
        for(i = 0; i < 2; i++){
            bookingHistoryList = new MyBookingList(
                    "Bobobox Name",
                    "Bobobox Type",
                    "21 sep 2017",
                    "22 sep 2017"
            );
            bookingHistoryLists.add(bookingHistoryList);
        }
        adapter = new MyBookingAdapter(bookingHistoryLists, HistoryBooking.this);
        ticketHistoryRV.setAdapter(adapter);
    }
}
