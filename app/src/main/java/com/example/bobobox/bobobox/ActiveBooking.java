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

public class ActiveBooking extends AppCompatActivity {

    private RecyclerView ticketActiveRV;
    private RecyclerView.Adapter adapter;
    private List<MyBookingList> bookingActiveLists;
    MyBookingList bookingActiveList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_booking);
        initialVariable();
    }

    private void initialVariable() {
        ticketActiveRV = (RecyclerView) findViewById(R.id.boboboxMBActiveRV);
        ticketActiveRV.setLayoutManager(new LinearLayoutManager(this));
        bookingActiveLists = new ArrayList<>();
        int i;
        for(i = 0; i < 3; i++){
            bookingActiveList = new MyBookingList(
                    "Bobobox Name",
                    "Bobobox Type",
                    "21 sep 2017",
                    "22 sep 2017"
            );
            bookingActiveLists.add(bookingActiveList);
        }
        adapter = new MyBookingAdapter(bookingActiveLists, ActiveBooking.this);
        ticketActiveRV.setAdapter(adapter);
    }
}
