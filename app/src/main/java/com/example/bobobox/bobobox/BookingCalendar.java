package com.example.bobobox.bobobox;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.bobobox.bobobox.Data.SharedPreference;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Unknown on 12/24/2017.
 */

public class BookingCalendar extends AppCompatActivity{

    private MaterialCalendarView bookingCalendar;

    private Class<?> classN = null;

    private SharedPreference sharedPreference = new SharedPreference();

    private static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private Button setDateBtn;

    private Intent intent = null;

    private String[] splitDate;

    private String dateSelected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_calendar);

        final Intent incomingIntent = getIntent();
        final String className = incomingIntent.getStringExtra("class");

        setDateBtn = (Button) findViewById(R.id.setDate);

        bookingCalendar = (MaterialCalendarView) findViewById(R.id.bookingCalendarCV);

        bookingCalendar.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2017, 11, 1))
                .setMaximumDate(CalendarDay.from(2050, 12, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        if(sharedPreference.getDateHourValue(BookingCalendar.this) != null){
            splitDate = sharedPreference.getDateHourValue(BookingCalendar.this).split("=");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            String dateInString = splitDate[0]+"-"+splitDate[1]+"-"+splitDate[2];
            try {
                Date date = formatter.parse(dateInString);
                bookingCalendar.setDateSelected(date, true);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            bookingCalendar.setDateSelected(Calendar.getInstance(), true);
        }

        setDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                Class<?> classType = null;
                try {
                    classType = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                if(className.equals("com.example.bobobox.bobobox.BookingDate"))
                    intent = new Intent(BookingCalendar.this, classType);

                if(className.equals("com.example.bobobox.bobobox.BookingHour"))
                    intent = new Intent(BookingCalendar.this, classType);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        bookingCalendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                String example = String.valueOf(date);
                Matcher m = Pattern.compile("\\{(.*?)\\}").matcher(example);
                String dateSelected = null;
                while(m.find()) {
                    dateSelected = m.group(1);
                }
                int dayOfMonth,month,year;
                String[] splitDate = dateSelected.split("-");
                dayOfMonth = Integer.parseInt(splitDate[2]);
                month = Integer.parseInt(splitDate[1]);
                year = Integer.parseInt(splitDate[0]);
                dateSelected = String.valueOf(dayOfMonth)+"="+String.valueOf(month)+"="+String.valueOf(year);

                if(className.equals("com.example.bobobox.bobobox.BookingHour"))
                    sharedPreference.saveDateHour(BookingCalendar.this, dateSelected);

                if(className.equals("com.example.bobobox.bobobox.BookingDate")){
                    if(incomingIntent.hasExtra("dateIn"))
                        sharedPreference.saveDateIn(BookingCalendar.this, dateSelected);
                    if(incomingIntent.hasExtra("dateOut"))
                        sharedPreference.saveDateOut(BookingCalendar.this, dateSelected);
                }
            }
        });
    }
}
