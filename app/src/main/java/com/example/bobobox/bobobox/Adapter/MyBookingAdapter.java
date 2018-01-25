package com.example.bobobox.bobobox.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bobobox.bobobox.Data.MyBookingList;
import com.example.bobobox.bobobox.R;

import java.util.List;

/**
 * Created by Unknown on 1/16/2018.
 */

public class MyBookingAdapter extends RecyclerView.Adapter<MyBookingAdapter.ViewHolder> {

    private List<MyBookingList> myBookingLists;
    private Context context;

    public MyBookingAdapter(List<MyBookingList> myBookingLists, Context context) {
        this.myBookingLists = myBookingLists;
        this.context = context;
    }

    @Override
    public MyBookingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booking_ticket_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyBookingAdapter.ViewHolder holder, int position) {
        final MyBookingList myBookingList = myBookingLists.get(position);

        holder.boboboxName.setText(myBookingList.getBoboboxName());
        holder.boboboxPrice.setText(myBookingList.getBoboboxType());
        holder.boboboxAddress.setText(myBookingList.getBoboboxCheckIn()+" - "+myBookingList.getBoboboxCheckOut());
    }

    @Override
    public int getItemCount() {
        return myBookingLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView boboboxName;
        public TextView boboboxPrice;
        public TextView boboboxAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            boboboxName = (TextView) itemView.findViewById(R.id.boboboxBINameTV);
            boboboxPrice = (TextView) itemView.findViewById(R.id.boboboxBITypeTV);
            boboboxAddress = (TextView) itemView.findViewById(R.id.boboboxBIPeriodTV);
        }
    }
}
