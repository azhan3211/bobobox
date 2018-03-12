package com.example.bobobox.bobobox.Data;

import com.example.bobobox.bobobox.Data.BoboboxAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ganteun unikom eka on 12/29/2017.
 */

public interface BoboboxDataInterface {
    @GET("room/search")
    Call<List<BoboboxAPI>> getBoboboxSearchRoom(@Query("position") String position,
                                                @Query("kota") String kota,
                                                @Query("check_in") String check_in);

    @GET("room/show")
    Call<List<BoboboxAPI>> getBoboboxDetail(@Query("id_hotel") String id_hotel,
                                      @Query("position") String position,
                                      @Query("check_in") String check_in);

    @GET("user/login")
    Call<User> getUser(@Query("username") String username,
                       @Query("password") String password);

    @POST("booking/store")
    Call<Booking> setBooking(@Body Booking booking);

    @POST("user/registration")
    Call<UserRegistration> setBoboboxUserRegistration(@Body UserRegistration userRegistration);
}
