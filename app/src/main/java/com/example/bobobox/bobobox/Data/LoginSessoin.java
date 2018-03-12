package com.example.bobobox.bobobox.Data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.EnumMap;

/**
 * Created by Unknown on 2/25/2018.
 */

public class LoginSessoin {

    public static final String PREF_NAME = "loginSession";
    public static final String PREF_ID_USER = "idUser";
    public static final String PREF_EMAIL = "email";
    public static final String PREF_USERNAME = "username";
    public static final String PREF_NO_TELP = "noTelp";

    private static SharedPreferences.Editor editor;
    private static SharedPreferences sharedPreferences;

    public LoginSessoin() {
        super();
    }

    public void save(Context context, String id, String username, String email, String noTelp){
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString(PREF_USERNAME, username);
        editor.putString(PREF_ID_USER, id);
        editor.putString(PREF_EMAIL, email);
        editor.putString(PREF_NO_TELP, noTelp);

        editor.commit();
    }

    public String getUsernameSession(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String username = null;
        if(sharedPreferences.contains(PREF_USERNAME)){
            username = sharedPreferences.getString(PREF_USERNAME, null);
        }
        return username;
    }

    public String getEmail(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(sharedPreferences.contains(PREF_EMAIL))
            text = sharedPreferences.getString(PREF_EMAIL, null);
        return text;
    }

    public String getId(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(sharedPreferences.contains(PREF_ID_USER))
            text = sharedPreferences.getString(PREF_ID_USER, null);
        return text;
    }

    public String getNoTelp(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String text = null;
        if(sharedPreferences.contains(PREF_NO_TELP))
            text = sharedPreferences.getString(PREF_NO_TELP, null);
        return text;
    }

    public void removeSession(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences.contains(PREF_USERNAME))
            editor.remove(PREF_USERNAME);

        if(sharedPreferences.contains(PREF_ID_USER))
            editor.remove(PREF_ID_USER);

        if(sharedPreferences.contains(PREF_EMAIL))
            editor.remove(PREF_EMAIL);

        if(sharedPreferences.contains(PREF_NO_TELP))
            editor.remove(PREF_NO_TELP);

        editor.commit();
    }
}
