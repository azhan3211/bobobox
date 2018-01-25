package com.example.bobobox.bobobox.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ganteun unikom eka on 12/29/2017.
 */

public class BoboboxRetrofit {

    public Retrofit syncBobobox() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.0.106/bobobox/public/api/v1/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        return retrofit;
    }
}
