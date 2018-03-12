package com.example.bobobox.bobobox.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bobobox.bobobox.Data.SharedPreference;
import com.example.bobobox.bobobox.R;

import java.text.DecimalFormat;

/**
 * Created by Unknown on 1/13/2018.
 */

public class BookingConfirmationStep2 extends AppCompatActivity {

    Button nextStepBtn;
    TextView boboboxName, checkIn, checkOut, hourIn, hourOut, position, breakfastNumber, breakfast, numberGuest, numberGuest2, guestName, price, breakfastPrice, uniqPrice, totalPrice;
    ImageView positionIV;
    SharedPreference sharedPreference = new SharedPreference();
    private static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_confirmation_step2);
        nextStepBtn = (Button) findViewById(R.id.boboboxBCNextStep2Btn);

        initialVariable();
        getData();

        nextStepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookingConfirmationStep2.this, BookingConfirmationStep3.class);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        String[] spliteDateIn = sharedPreference.getDateInValue(BookingConfirmationStep2.this).split("=");
        String[] spliteDateOut = sharedPreference.getDateOutValue(BookingConfirmationStep2.this).split("=");
        String p = sharedPreference.getPosition(BookingConfirmationStep2.this);
        final DecimalFormat money = new DecimalFormat("#,###,###");
        int harga = Integer.parseInt(sharedPreference.getNumberGuest(BookingConfirmationStep2.this).replaceAll("[^0-9]", ""))*Integer.parseInt(String.valueOf(sharedPreference.getPrice(BookingConfirmationStep2.this)));
        int breakfast_price = 0;
        if(sharedPreference.getBreakfast(BookingConfirmationStep2.this).equals("1")) {
            breakfast_price = 15000;
            breakfast_price = breakfast_price * Integer.parseInt(sharedPreference.getNumberGuest(BookingConfirmationStep2.this).replaceAll("[^0-9]", ""));
        }
        int totalP = harga+breakfast_price+145;

        boboboxName.setText(sharedPreference.getNameRoom(BookingConfirmationStep2.this));
        checkIn.setText(spliteDateIn[0]+" "+months[Integer.parseInt(spliteDateIn[1])]+" "+spliteDateIn[2]);
        checkOut.setText(spliteDateOut[0]+" "+months[Integer.parseInt(spliteDateOut[1])]+" "+spliteDateOut[2]);
        hourIn.setText(sharedPreference.getHourInValue(BookingConfirmationStep2.this));
        hourOut.setText(sharedPreference.getHourOutValue(BookingConfirmationStep2.this));
        position.setText("Bobobox "+p);

        if(p.toLowerCase().equals("sky"))
            positionIV.setImageResource(R.drawable.ic_room_type1);

        numberGuest.setText(sharedPreference.getNumberGuest(BookingConfirmationStep2.this));
        numberGuest2.setText(sharedPreference.getNumberGuest(BookingConfirmationStep2.this));
        breakfastNumber.setText("Breakfast ("+sharedPreference.getNumberGuest(BookingConfirmationStep2.this)+")");

        if(sharedPreference.getBreakfast(BookingConfirmationStep2.this).equals("1"))
            breakfast.setText("Yes");
        else
            breakfast.setText("No");

        price.setText(money.format(Double.valueOf(String.valueOf(harga))));
        breakfastPrice.setText(money.format(breakfast_price).replace(",", "."));
        totalPrice.setText(money.format(totalP).replace(",", "."));

        sharedPreference.saveTotalPrice(BookingConfirmationStep2.this, String.valueOf(totalP));
    }

    private void initialVariable() {
        boboboxName = (TextView) findViewById(R.id.boboboxBC2NameRoomTV);
        checkIn = (TextView) findViewById(R.id.boboboxBC2DateInTV);
        checkOut = (TextView) findViewById(R.id.boboboxBC2DateOutTV);
        hourIn = (TextView) findViewById(R.id.boboboxBC2HourInTV);
        hourOut = (TextView) findViewById(R.id.boboboxBC2HourOutTV);
        position = (TextView) findViewById(R.id.boboboxBC2RoomTypeTV);
        breakfast = (TextView) findViewById(R.id.boboboxBC2BreakfastTV);
        numberGuest = (TextView) findViewById(R.id.boboboxBC2GuestNumberTV);
        numberGuest2 = (TextView) findViewById(R.id.boboboxBC2GuestTV);
        guestName = (TextView) findViewById(R.id.boboboxBC2GuestTV);
        price = (TextView) findViewById(R.id.boboboxBC2PriceTV);
        breakfastPrice = (TextView) findViewById(R.id.boboboxBC2BreakfastPriceTV);
        breakfastNumber = (TextView) findViewById(R.id.boboboxBC2BreakfastNumberTV);
        uniqPrice = (TextView) findViewById(R.id.boboboxBC2UniqueCodeTV);
        totalPrice = (TextView) findViewById(R.id.boboboxBC2TotalPriceTV);
        positionIV = (ImageView) findViewById(R.id.boboboxBC2RoomTypeIV);
    }
}