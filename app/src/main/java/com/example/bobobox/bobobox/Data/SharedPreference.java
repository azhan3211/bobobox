package com.example.bobobox.bobobox.Data;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;

/**
 * Created by ganteun unikom eka on 12/17/2017.
 */

public class SharedPreference {

    public static final String PREFS_NAME = "dateSelected";
    public static final String PREFS_HOUR_IN = "hourIn";
    public static final String PREFS_HOUR_OUT = "hourOut";
    public static final String PREFS_DATE_HOUR = "dateHour";
    public static final String PREFS_DATE_IN = "dateIn";
    public static final String PREFS_DATE_OUT = "dateOut";
    public static final String PREFS_POSITION = "position";
    public static final String PREFS_ID_HOTEL = "idHotel";
    public static final String PREFS_NUMBER_GUEST= "numberGuest";
    public static final String PREFS_NUMBER_ROOM = "numberRoom";
    public static final String PREFS_NAME_ROOM = "nameRoom";
    public static final String PREFS_BREAKFAST = "breakfast";
    public static final String PREFS_PRICE = "price";
    public static final String PREFS_TOTAL_PRICE = "totalPrice";
    public static final String PREFS_BOOKING_TYPE = "typeBooking";

    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    public SharedPreference() {
        super();
    }

    public void saveIdHotel(Context context, String text) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putString(PREFS_ID_HOTEL, text); //3

        editor.commit(); //4
    }

    public void saveNameRoom(Context context, String nameRoom){

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putString(PREFS_NAME_ROOM, nameRoom);

        editor.commit();
    }


    public void saveNumberRoom(Context context, String text) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putString(PREFS_NUMBER_ROOM, text); //3

        editor.commit(); //4
    }

    public void saveNumberGuest(Context context, String text) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putString(PREFS_NUMBER_GUEST, text); //3

        editor.commit(); //4
    }

    public void savePosition(Context context, String text) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putString(PREFS_POSITION, text); //3

        editor.commit(); //4
    }

    public void saveDateHour(Context context, String text) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putString(PREFS_DATE_HOUR, text); //3

        editor.commit(); //4
    }

    public void saveHourIn(Context context, String text){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putString(PREFS_HOUR_IN, text);

        editor.commit();
    }

    public void saveHourOut(Context context, String text){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putString(PREFS_HOUR_OUT, text);
        editor.commit();
    }

    public void saveDateIn(Context context, String text) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putString(PREFS_DATE_IN, text); //3

        editor.commit(); //4
    }

    public void saveDateOut(Context context, String text) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putString(PREFS_DATE_OUT, text); //3

        editor.commit(); //4
    }

    public void saveBreakfast(Context context, String text){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putString(PREFS_BREAKFAST, text);

        editor.commit();
    }

    public void savePrice(Context context, String text){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putString(PREFS_PRICE, text);

        editor.commit();
    }

    public void saveTotalPrice(Context context, String text){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putString(PREFS_TOTAL_PRICE, text);

        editor.commit();
    }

    public void saveBookingType(Context context, String text){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putString(PREFS_BOOKING_TYPE, text);

        editor.commit();
    }

    public String getIdHotel(Context context) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_ID_HOTEL))
            text = settings.getString(PREFS_ID_HOTEL, null);

        return text;
    }

    public String getNameRoom(Context context){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_NAME_ROOM))
            text = settings.getString(PREFS_NAME_ROOM, null);
        return text;
    }


    public String getNumberGuest(Context context) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_NUMBER_GUEST))
            text = settings.getString(PREFS_NUMBER_GUEST, null);

        return text;
    }

    public String getNumberRoom(Context context) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_NUMBER_ROOM))
            text = settings.getString(PREFS_NUMBER_ROOM, null);

        return text;
    }

    public String getTotalPrice(Context context){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_TOTAL_PRICE))
            text = settings.getString(PREFS_TOTAL_PRICE, null);
        return text;
    }

    public String getPosition(Context context) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_POSITION))
            text = settings.getString(PREFS_POSITION, null);

        return text;
    }

    public String getDateHourValue(Context context) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_DATE_HOUR))
            text = settings.getString(PREFS_DATE_HOUR, null);

        return text;
    }

    public String getHourInValue(Context context){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_HOUR_IN))
            text = settings.getString(PREFS_HOUR_IN, null);
        return text;
    }

    public String getHourOutValue(Context context){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_HOUR_OUT))
            text = settings.getString(PREFS_HOUR_OUT, null);
        return text;
    }

    public String getDateInValue(Context context) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_DATE_IN))
            text = settings.getString(PREFS_DATE_IN, null);
        return text;
    }

    public String getDateOutValue(Context context) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_DATE_OUT))
            text = settings.getString(PREFS_DATE_OUT, null);
        return text;
    }

    public String getBreakfast (Context context){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_BREAKFAST))
            text = settings.getString(PREFS_BREAKFAST, null);
        return text;
    }

    public String getPrice(Context context){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_PRICE))
            text = settings.getString(PREFS_PRICE, null);
        return text;
    }

    public String getBookingType(Context context){
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(settings.contains(PREFS_BOOKING_TYPE))
            text = settings.getString(PREFS_BOOKING_TYPE, null);
        return text;
    }

    public void removeAllValue(Context context) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        if(settings.contains(PREFS_DATE_HOUR))
            editor.remove(PREFS_DATE_HOUR);

        if(settings.contains(PREFS_HOUR_IN))
            editor.remove(PREFS_HOUR_IN);

        if(settings.contains(PREFS_HOUR_OUT))
            editor.remove(PREFS_HOUR_OUT);

        if(settings.contains(PREFS_DATE_IN))
            editor.remove(PREFS_DATE_IN);

        if(settings.contains(PREFS_DATE_OUT))
            editor.remove(PREFS_DATE_OUT);

        if(settings.contains(PREFS_POSITION))
            editor.remove(PREFS_POSITION);

        if(settings.contains(PREFS_ID_HOTEL))
            editor.remove(PREFS_ID_HOTEL);

        if(settings.contains(PREFS_NUMBER_ROOM))
            editor.remove(PREFS_NUMBER_ROOM);

        if(settings.contains(PREFS_NUMBER_GUEST))
            editor.remove(PREFS_NUMBER_GUEST);

        if(settings.contains(PREFS_NAME_ROOM))
            editor.remove(PREFS_NAME_ROOM);

        if(settings.contains(PREFS_BREAKFAST))
            editor.remove(PREFS_BREAKFAST);

        if(settings.contains(PREFS_PRICE))
            editor.remove(PREFS_PRICE);

        if(settings.contains((PREFS_TOTAL_PRICE)))
            editor.remove(PREFS_TOTAL_PRICE);

        if(settings.contains(PREFS_BOOKING_TYPE))
            editor.remove(PREFS_BOOKING_TYPE);

        editor.commit();
    }
}
