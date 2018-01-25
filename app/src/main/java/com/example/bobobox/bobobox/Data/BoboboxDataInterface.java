package com.example.bobobox.bobobox.Data;

import com.example.bobobox.bobobox.Data.BoboboxAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ganteun unikom eka on 12/29/2017.
 */

public interface BoboboxDataInterface {
    @GET("room/search")
    Call<List<BoboboxAPI>> getBoboboxData(@Query("position") String position,
                                          @Query("kota") String kota);
}
