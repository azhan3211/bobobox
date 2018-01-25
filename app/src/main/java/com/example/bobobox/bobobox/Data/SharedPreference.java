package com.example.bobobox.bobobox.Data;

import android.content.Context;
import android.content.SharedPreferences;

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

    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    public SharedPreference() {
        super();
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

        editor.commit();
    }
}
