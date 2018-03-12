package com.example.bobobox.bobobox.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bobobox.bobobox.Data.BoboboxDataInterface;
import com.example.bobobox.bobobox.Data.Booking;
import com.example.bobobox.bobobox.Data.LoginSessoin;
import com.example.bobobox.bobobox.Data.SharedPreference;
import com.example.bobobox.bobobox.R;
import com.example.bobobox.bobobox.Service.BoboboxRetrofit;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Unknown on 1/13/2018.
 */

public class BookingConfirmationStep3 extends AppCompatActivity {

    Button nextBtn;
    TextView totalPrice, boboboxName, dateIn, totalNight;
    SharedPreference sharedPreference = new SharedPreference();
    private static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String id_jenis_booking, id_user, id_room, email, no_telp, check_in, check_out, breakfast, uniq_code;
    LoginSessoin loginSessoin = new LoginSessoin();
    BoboboxRetrofit boboboxRetrofit;
    Retrofit retrofit;
    BoboboxDataInterface boboboxDataInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_confirmation_step3);
        nextBtn = (Button) findViewById(R.id.boboboxBCNextStep3Btn);
        initialVariable();
        getData();
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Booking(id_jenis_booking, id_user, id_room, email, no_telp, check_in, check_out, breakfast, uniq_code)
                id_jenis_booking = sharedPreference.getBookingType(BookingConfirmationStep3.this);
                id_user = loginSessoin.getId(BookingConfirmationStep3.this);
                id_room = sharedPreference.getIdHotel(BookingConfirmationStep3.this);
                email = loginSessoin.getEmail(BookingConfirmationStep3.this);
                no_telp = loginSessoin.getNoTelp(BookingConfirmationStep3.this);
                check_in = sharedPreference.getDateInValue(BookingConfirmationStep3.this);
                check_out = sharedPreference.getDateOutValue(BookingConfirmationStep3.this);
                breakfast = sharedPreference.getBreakfast(BookingConfirmationStep3.this);

                String splitDate[];
                splitDate = check_in.split("=");
                check_in = splitDate[2]+"-"+(Integer.parseInt(splitDate[1])+1)+"-"+splitDate[0];

                splitDate = check_out.split("=");
                check_out = splitDate[2]+"-"+(Integer.parseInt(splitDate[1])+1)+"-"+splitDate[0];
                uniq_code = "145";
                Booking booking = new Booking(
                        id_jenis_booking,
                        id_user,
                        id_room,
                        email,
                        no_telp,
                        check_in,
                        check_out,
                        breakfast,
                        uniq_code
                );
                Call<Booking> call = boboboxDataInterface.setBooking(booking);
                call.enqueue(new Callback<Booking>() {
                    @Override
                    public void onResponse(Call<Booking> call, Response<Booking> response) {
                        Log.d("id_booking", response.body().getId());
                    }

                    @Override
                    public void onFailure(Call<Booking> call, Throwable t) {

                    }
                });
                Intent intent = new Intent(BookingConfirmationStep3.this, BookingResult.class);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        DecimalFormat money = new DecimalFormat("#,###,###");
        String[] splitDate = sharedPreference.getDateInValue(BookingConfirmationStep3.this).split("=");

        totalPrice.setText("Rp. "+money.format(Double.parseDouble(sharedPreference.getTotalPrice(BookingConfirmationStep3.this))).replace(",","."));
        boboboxName.setText(sharedPreference.getNameRoom(BookingConfirmationStep3.this));
        dateIn.setText(splitDate[0]+" "+months[Integer.parseInt(splitDate[1])]+" "+splitDate[2]);
    }

    private void initialVariable() {
        totalPrice = (TextView) findViewById(R.id.boboboxBC3TotalPriceTV);
        boboboxName = (TextView) findViewById(R.id.boboboxBC3NameRoomTV);
        dateIn = (TextView) findViewById(R.id.boboboxBC3DateInfoTV);
        boboboxRetrofit = new BoboboxRetrofit();
        retrofit = boboboxRetrofit.syncBobobox();
        boboboxDataInterface = retrofit.create(BoboboxDataInterface.class);
    }
}
