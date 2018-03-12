package com.example.bobobox.bobobox.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bobobox.bobobox.Data.Booking;
import com.example.bobobox.bobobox.Data.SharedPreference;
import com.example.bobobox.bobobox.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ganteun unikom eka on 12/22/2017.
 */

public class BookingDate extends AppCompatActivity implements View.OnClickListener {

    private EditText room, person;

    private int numberRoom = 0;
    private int numberPerson = 0;

    private ImageView btnPlusRoom, btnPlusPerson, btnMinusRoom, btnMinusPerson;

    private ImageView skyPosition, earthPosition;

    private Calendar c = Calendar.getInstance();
    private int mYear = c.get(Calendar.YEAR);
    private int mMonth = c.get(Calendar.MONTH);
    private int mDay = c.get(Calendar.DAY_OF_MONTH);

    private int mYear2 = c.get(Calendar.YEAR);
    private int mMonth2 = c.get(Calendar.MONTH);
    private int mDay2 = c.get(Calendar.DAY_OF_MONTH);

    private SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");

    private RelativeLayout dateInSelectRL, dateOutSelectRL;

    private TextView dateInTV, dateInMonthYearTV, dateInDayTV, dateOutTV, dateOutMonthYearTV, dateOutDayTV;
    private AutoCompleteTextView citiesACTV;

    private static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static String[] cities = {"Bandung", "Jakarta"};
    private Intent intent;
    private Button btnSearch;

    private String roomPosition = "sky";

    private SharedPreference sharedPreference = new SharedPreference();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_date_layout);
        sharedPreference.saveBookingType(BookingDate.this, "1");

        initialVariable();
        btnPlusMinus();

        showSelectedDate();

        dateInSelectRL.setOnClickListener(this);
        dateOutSelectRL.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        skyPosition.setOnClickListener(this);
        earthPosition.setOnClickListener(this);
    }

    private void showSelectedDate() {
        String[] splitDate;
        if(sharedPreference.getDateInValue(BookingDate.this) != null){
            splitDate = sharedPreference.getDateInValue(BookingDate.this).split("=");

            Date date = new Date(Integer.parseInt(splitDate[2]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[0])-1);
            String dayOfWeek = simpledateformat.format(date);

            dateInTV.setText(String.valueOf(splitDate[0]));
            dateInMonthYearTV.setText(months[Integer.parseInt(splitDate[1])]+", "+String.valueOf(splitDate[2]));
            dateInDayTV.setText(dayOfWeek);
            mMonth = Integer.parseInt(splitDate[1]);
            mYear = Integer.parseInt(splitDate[2]);
        }

        if(sharedPreference.getDateOutValue(BookingDate.this) != null){
            splitDate = sharedPreference.getDateOutValue(BookingDate.this).split("=");

            Date date = new Date(Integer.parseInt(splitDate[2]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[0])-1);
            String dayOfWeek = simpledateformat.format(date);

            dateOutTV.setText(String.valueOf(splitDate[0]));
            dateOutMonthYearTV.setText(months[Integer.parseInt(splitDate[1])]+", "+String.valueOf(splitDate[2]));
            dateOutDayTV.setText(dayOfWeek);
            mMonth2 = Integer.parseInt(splitDate[1]);
            mYear2 = Integer.parseInt(splitDate[2]);
        }
    }

    private void decreaseKeyRoomNumber() {
        if (!room.getText().toString().equals("")){
            numberRoom = Integer.valueOf(room.getText().toString());
            numberRoom--;
            if (numberRoom > 0) {
                setRoomNumber(numberRoom);
            } else {
                setRoomNumber(1);
            }
        }
    }

    private void increaseKeyRoomNumber(){
        if(!room.getText().toString().equals("")) {
            numberRoom = Integer.valueOf(room.getText().toString());
            numberRoom++;
            setRoomNumber(numberRoom);
        } else
            setRoomNumber(1);
    }

    private void decreasePersonNumber(){
        if(!person.getText().toString().equals("")) {
            numberPerson = Integer.valueOf(person.getText().toString());
            numberPerson--;
            if (numberPerson > 0) {
                setPersonNumber(numberPerson);
            } else {
                setPersonNumber(1);
            }
        }
    }

    private void increasePersonNumber(){
        if(!person.getText().toString().equals("")) {
            numberPerson = Integer.valueOf(person.getText().toString());
            numberPerson++;
            setPersonNumber(numberPerson);
        } else
            setPersonNumber(1);
    }

    private void setRoomNumber(int numberRoom){
        room = (EditText) findViewById(R.id.dateNumberRoom);
        room.setText(String.valueOf(numberRoom));
    }

    private void setPersonNumber(int numberPerson){
        person = (EditText) findViewById(R.id.dateNumberPerson);
        person.setText(String.valueOf(numberPerson));
    }

    private void btnPlusMinus(){
        btnPlusRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseKeyRoomNumber();
            }
        });

        btnPlusPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increasePersonNumber();
            }
        });

        btnMinusRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decreaseKeyRoomNumber();
            }
        });

        btnMinusPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decreasePersonNumber();
            }
        });
    }

    private void initialVariable(){
        dateInTV = (TextView) findViewById(R.id.dateInBookingTV);
        dateInMonthYearTV = (TextView) findViewById(R.id.dateInYearBookingTV);
        dateInDayTV = (TextView) findViewById(R.id.dateInDayBookingTV);

        dateOutTV = (TextView) findViewById(R.id.dateOutBookingTV);
        dateOutMonthYearTV = (TextView) findViewById(R.id.dateOutYearBookingTV);
        dateOutDayTV = (TextView) findViewById(R.id.dateOutDayBookingTV);

        room = (EditText) findViewById(R.id.dateNumberRoom);
        person = (EditText) findViewById(R.id.dateNumberPerson);

//        city = (EditText) findViewById(R.id.boboboxBCityDateET);

        btnPlusRoom = (ImageView) findViewById(R.id.dateBtnPlusRoom);
        btnPlusPerson = (ImageView) findViewById(R.id.dateBtnPlusPerson);
        btnMinusRoom = (ImageView) findViewById(R.id.dateBtnMinusRoom);
        btnMinusPerson= (ImageView) findViewById(R.id.dateBtnMinusPerson);

        skyPosition = (ImageView) findViewById(R.id.boboboxBDSkyIV);
        earthPosition = (ImageView) findViewById(R.id.boboboxBDEarthIV);

        dateInSelectRL = (RelativeLayout) findViewById(R.id.dateInSelect);
        dateOutSelectRL = (RelativeLayout) findViewById(R.id.dateOutSelect);

        Date date = new Date(mYear, mMonth, mDay-1);
        String dayOfWeek = simpledateformat.format(date);

        dateInTV.setText(String.valueOf(mDay));
        dateInMonthYearTV.setText(months[mMonth]+", "+String.valueOf(mYear));
        dateInDayTV.setText(dayOfWeek);

        dateOutTV.setText(String.valueOf(mDay));
        dateOutMonthYearTV.setText(months[mMonth]+", "+String.valueOf(mYear));
        dateOutDayTV.setText(dayOfWeek);

        btnSearch = (Button) findViewById(R.id.btnSearchDate);

        citiesACTV = (AutoCompleteTextView) findViewById(R.id.boboboxBDCityACTV);
        citiesACTV.setAdapter(new ArrayAdapter(BookingDate.this, android.R.layout.simple_list_item_1, cities));
        citiesACTV.setThreshold(1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(getIntent().getStringExtra("city") != null)
            citiesACTV.setText(getIntent().getStringExtra("city"));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.dateInSelect:
                intent = new Intent(BookingDate.this, BookingCalendar.class);
                intent.putExtra("class","com.example.bobobox.bobobox.UI.BookingDate");
                intent.putExtra("dateIn", "Y");
                if(!citiesACTV.getText().equals(""))
                    intent.putExtra("city", citiesACTV.getText().toString());
                startActivity(intent);
                break;
            case R.id.dateOutSelect:
                intent = new Intent(BookingDate.this, BookingCalendar.class);
                intent.putExtra("class","com.example.bobobox.bobobox.UI.BookingDate");
                intent.putExtra("dateOut", "Y");
                if(!citiesACTV.getText().equals(""))
                    intent.putExtra("city", citiesACTV.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnSearchDate:
                intent = new Intent(BookingDate.this, SearchResult.class);
                intent.putExtra("class","com.example.bobobox.bobobox.UI.BookingDate");
                intent.putExtra("dateIn", dateInTV.getText().toString());
                intent.putExtra("dateOut", dateOutTV.getText().toString());
                intent.putExtra("monthIn", String.valueOf(mMonth));
                intent.putExtra("monthOut", String.valueOf(mMonth2));
                intent.putExtra("yearIn", String.valueOf(mYear));
                intent.putExtra("yearOut", String.valueOf(mYear2));
                intent.putExtra("dateInDay",dateInDayTV.getText().toString());
                intent.putExtra("dateOutDay", dateOutDayTV.getText().toString());
                intent.putExtra("city", citiesACTV.getText().toString());

                if(person.getText().toString().equals(""))
                    intent.putExtra("numberPerson", "1");
                else
                    intent.putExtra("numberPerson", person.getText().toString());

                if(room.getText().toString().equals(""))
                    intent.putExtra("numberRoom", "1");
                else
                    intent.putExtra("numberRoom", room.getText().toString());

                if(roomPosition.equals("sky"))
                    intent.putExtra("roomPosition", "Sky");
                else
                    intent.putExtra("roomPosition", "Earth");
                startActivity(intent);
                break;
            case R.id.boboboxBDEarthIV:
                earthPosition.setColorFilter(ContextCompat.getColor(BookingDate.this, R.color.colorTheme));
                skyPosition.setColorFilter(ContextCompat.getColor(BookingDate.this, R.color.colorUnselected));
                roomPosition = "earth";
                break;
            case R.id.boboboxBDSkyIV:
                skyPosition.setColorFilter(ContextCompat.getColor(BookingDate.this, R.color.colorTheme));
                earthPosition.setColorFilter(ContextCompat.getColor(BookingDate.this, R.color.colorUnselected));
                roomPosition = "sky";
                break;
            default:
                break;
        }
    }
}
