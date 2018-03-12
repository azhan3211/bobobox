package com.example.bobobox.bobobox.UI;

import android.app.TimePickerDialog;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.bobobox.bobobox.Data.SharedPreference;
import com.example.bobobox.bobobox.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ganteun unikom eka on 12/22/2017.
 */

public class BookingHour extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout dateSelectRL;
    private LinearLayout timeS,timeE;
    private TextView dateTV;
    private TextView monthYearTV;
    private TextView dayTV;

    private TextView timeSS,timeES;

    private EditText room;
    private EditText person;

//    private EditText city;

    private static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private Calendar c = Calendar.getInstance();
    private int mYear = c.get(Calendar.YEAR);
    private int mMonth = c.get(Calendar.MONTH);
    private int mDay = c.get(Calendar.DAY_OF_MONTH);
    private int mHour = c.get(Calendar.HOUR_OF_DAY);
    private int mMinute = c.get(Calendar.MINUTE);
    private String h,m;

    private SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");

    private Intent intent;

    private ImageView btnPlusRoom;
    private ImageView btnPlusPerson;

    private ImageView btnMinusRoom;
    private ImageView btnMinusPerson;

    private ImageView skyPosition, earthPosition;

    private AutoCompleteTextView citiesACTV;
    private int numberRoom = 0;
    private int numberPerson = 0;

    private Button btnSearch;

    private String roomPosition = "sky";
    private static String[] cities = {"Bandung", "Jakarta"};

    private SharedPreference sharedPreference = new SharedPreference();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_hour_layout);
        sharedPreference.saveBookingType(BookingHour.this, "2");

        initialVariable();

        btnPlusMinus();

        showSelectedDate();

        dateSelectRL.setOnClickListener(this);
        timeS.setOnClickListener(this);
        timeE.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        skyPosition.setOnClickListener(this);
        earthPosition.setOnClickListener(this);
    }

    private void timePicker(final TextView showTime, final String identify){
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String am_pm = null;
                        if (c.get(Calendar.AM_PM) == Calendar.AM)
                            am_pm = "AM";
                        else if (c.get(Calendar.AM_PM) == Calendar.PM)
                            am_pm = "PM";

                        mHour = hourOfDay;
                        mMinute = minute;
                        String h;
                        String m;

                        if(hourOfDay < 10)
                            h = "0"+String.valueOf(hourOfDay);
                        else
                            h = String.valueOf(hourOfDay);

                        if(minute < 10)
                            m = "0"+String.valueOf(minute);
                        else
                            m = String.valueOf(minute);

                        showTime.setText(h + "." + m);
                        if(identify.equals("in"))
                            sharedPreference.saveHourIn(BookingHour.this, showTime.getText().toString());

                        if(identify.equals("out"))
                            sharedPreference.saveHourOut(BookingHour.this, showTime.getText().toString());
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void showSelectedDate() {
        String[] splitDate;

        if(sharedPreference.getDateHourValue(BookingHour.this) != null){
            splitDate = sharedPreference.getDateHourValue(BookingHour.this).split("=");
            Date date = new Date(Integer.parseInt(splitDate[2]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[0]) - 1);
            String dayOfWeek = simpledateformat.format(date);

            dateTV.setText(String.valueOf(splitDate[0]));
            monthYearTV.setText(months[Integer.parseInt(splitDate[1])] + ", " + String.valueOf(splitDate[2]));
            dayTV.setText(dayOfWeek);
            mMonth = Integer.parseInt(splitDate[1]);
            mYear = Integer.parseInt(splitDate[2]);
        }

        if(sharedPreference.getHourInValue(BookingHour.this) != null)
            timeSS.setText(sharedPreference.getHourInValue(BookingHour.this));

        if(sharedPreference.getHourOutValue(BookingHour.this) != null)
            timeES.setText(sharedPreference.getHourOutValue(BookingHour.this));
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
        room = (EditText) findViewById(R.id.hourNumberRoom);
        room.setText(String.valueOf(numberRoom));
    }

    private void setPersonNumber(int numberPerson){
        person = (EditText) findViewById(R.id.hourNumberPerson);
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
        dateTV = (TextView) findViewById(R.id.hourDateBookingTV);
        monthYearTV = (TextView) findViewById(R.id.hourDateYearBookingTV);
        dayTV = (TextView) findViewById(R.id.hourDayBookingTV);

        timeSS = (TextView) findViewById(R.id.timeStartSet);
        timeES = (TextView) findViewById(R.id.timeEndSet);

        if(mHour < 10)
            h = "0"+String.valueOf(mHour);
        else
            h = String.valueOf(mHour);

        if(mMinute < 10)
            m = "0"+String.valueOf(mMinute);
        else
            m = String.valueOf(mMinute);

        timeES.setText(h+"."+m);
        timeSS.setText(h+"."+m);

        btnPlusRoom = (ImageView) findViewById(R.id.hourBtnPlusRoom);
        btnPlusPerson = (ImageView) findViewById(R.id.hourBtnPlusPerson);
        btnMinusRoom = (ImageView) findViewById(R.id.hourBtnMinusRoom);
        btnMinusPerson= (ImageView) findViewById(R.id.hourBtnMinusPerson);

        skyPosition = (ImageView) findViewById(R.id.boboboxBHSkyIV);
        earthPosition = (ImageView) findViewById(R.id.boboboxBHEarthIV);

        room = (EditText) findViewById(R.id.hourNumberRoom);
        person = (EditText) findViewById(R.id.hourNumberPerson);

//        city = (EditText) findViewById(R.id.boboboxBCityHourET);

        dateSelectRL = (RelativeLayout) findViewById(R.id.hourDateSelectRL);
        timeS = (LinearLayout) findViewById(R.id.timeStart);
        timeE = (LinearLayout) findViewById(R.id.timeEnd);

        Date date = new Date(mYear, mMonth, mDay-1);
        String dayOfWeek = simpledateformat.format(date);

        dateTV.setText(String.valueOf(mDay));
        monthYearTV.setText(months[mMonth]+", "+String.valueOf(mYear));
        dayTV.setText(dayOfWeek);

        btnSearch = (Button) findViewById(R.id.btnSearchHour);
        citiesACTV = (AutoCompleteTextView) findViewById(R.id.boboboxBHCityACTV);
        citiesACTV.setAdapter(new ArrayAdapter(BookingHour.this, android.R.layout.simple_list_item_1, cities));
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
            case R.id.hourDateSelectRL:
                intent = new Intent(BookingHour.this, BookingCalendar.class);
                intent.putExtra("class","com.example.bobobox.bobobox.UI.BookingHour");
                if(!citiesACTV.getText().equals(""))
                    intent.putExtra("city", citiesACTV.getText().toString());
                startActivity(intent);
                break;
            case R.id.timeStart:
                timePicker(timeSS, "in");
                break;
            case R.id.timeEnd:
                timePicker(timeES, "out");
                break;
            case R.id.btnSearchHour:
                intent = new Intent(BookingHour.this, SearchResult.class);
                intent.putExtra("class","com.example.bobobox.bobobox.UI.BookingHour");
                intent.putExtra("hourDateIn", dateTV.getText().toString());
                intent.putExtra("hourDateOut", dateTV.getText().toString());
                intent.putExtra("hourYear", String.valueOf(mYear));
                intent.putExtra("hourMonth", String.valueOf(mMonth));
                intent.putExtra("hourInDay",dayTV.getText().toString());
                intent.putExtra("hourOutDay", dayTV.getText().toString());
                intent.putExtra("hourIn",timeSS.getText().toString());
                intent.putExtra("hourOut", timeES.getText().toString());
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
            case R.id.boboboxBHEarthIV:
                earthPosition.setColorFilter(ContextCompat.getColor(BookingHour.this, R.color.colorTheme));
                skyPosition.setColorFilter(ContextCompat.getColor(BookingHour.this, R.color.colorUnselected));
                roomPosition = "earth";
                break;
            case R.id.boboboxBHSkyIV:
                skyPosition.setColorFilter(ContextCompat.getColor(BookingHour.this, R.color.colorTheme));
                earthPosition.setColorFilter(ContextCompat.getColor(BookingHour.this, R.color.colorUnselected));
                roomPosition = "sky";
                break;
            default:
                break;
        }
    }
}
