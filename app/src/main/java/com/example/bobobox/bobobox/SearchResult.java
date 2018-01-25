package com.example.bobobox.bobobox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bobobox.bobobox.Adapter.BoboboxAdapter;
import com.example.bobobox.bobobox.Data.BoboboxDataInterface;
import com.example.bobobox.bobobox.Data.BoboboxAPI;
import com.example.bobobox.bobobox.Data.BoboboxList;
import com.example.bobobox.bobobox.Data.SharedPreference;
import com.example.bobobox.bobobox.Service.BoboboxRetrofit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by ganteun unikom eka on 12/22/2017.
 */

public class SearchResult extends AppCompatActivity {

    private SharedPreference sharedPreference = new SharedPreference();
    private TextView dateInSearch, dateOutSearch, hourInSearch, hourOutSearch, numberRoomSearch, numberPersonSearch;
    private TextView monthYearInSearch, monthYearOutSearch;

    private static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private BoboboxList boboboxList;
    private List<BoboboxList> boboboxLists;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private Calendar c = Calendar.getInstance();
    private int mHour = c.get(Calendar.HOUR_OF_DAY);
    private int mMinute = c.get(Calendar.MINUTE);
    private String h,m;

    private Intent incomingIntent;
    private String className;

    private String city, roomPosition;

    RelativeLayout nextToBC;

    private String guest = "Guest",room = "Room";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result_layout);

        initialVariable();

        classChecker();

        getData();
    }

    private void getData() {
        BoboboxRetrofit builder = new BoboboxRetrofit();
        Retrofit retrofit = builder.syncBobobox();
        BoboboxDataInterface boboboxDataInterface = retrofit.create(BoboboxDataInterface.class);
        Call<List<BoboboxAPI>> call = boboboxDataInterface.getBoboboxData(roomPosition, city);
        call.enqueue(new Callback<List<BoboboxAPI>>() {
            @Override
            public void onResponse(Call<List<BoboboxAPI>> call, Response<List<BoboboxAPI>> response) {
                if(response.isSuccessful()) {
                    List<BoboboxAPI> result = response.body();
                    Log.d("jumlah result ", String.valueOf(result.size()));
                    int id;
                    String namaHotel;
                    Double rating;
                    String harga;
                    String alamat;
                    String negara;
                    String position;
                    int i = 0;
                    while (i < result.size()) {
                        id = result.get(i).getId();
                        namaHotel = result.get(i).getNamaHotel();
                        alamat = result.get(i).getAlamat();
                        harga = result.get(i).getHarga();
                        negara = result.get(i).getNegara();
                        rating = result.get(i).getRating();
                        position = result.get(i).getPosition();
                        boboboxList = new BoboboxList(
                            id,
                            namaHotel,
                            rating,
                            harga,
                            alamat,
                            negara,
                            position
                        );
                        boboboxLists.add(boboboxList);
                        i++;
                    }
                    adapter = new BoboboxAdapter(boboboxLists, SearchResult.this);
                    recyclerView.setAdapter(adapter);
                } else
                    Toast.makeText(SearchResult.this, "Stupid RETROFIT!!!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<BoboboxAPI>> call, Throwable t) {

            }
        });
    }

    private void classChecker() {
        if(className.equals("com.example.bobobox.bobobox.BookingDate")) {
            dateInSearch.setText(incomingIntent.getStringExtra("dateInDay").substring(0,3)+", "+incomingIntent.getStringExtra("dateIn"));
            dateOutSearch.setText(incomingIntent.getStringExtra("dateOutDay").substring(0,3)+", "+incomingIntent.getStringExtra("dateOut"));
            monthYearInSearch.setText(months[Integer.parseInt(incomingIntent.getStringExtra("monthIn"))]+" "+incomingIntent.getStringExtra("yearIn"));
            monthYearOutSearch.setText(months[Integer.parseInt(incomingIntent.getStringExtra("monthOut"))]+" "+incomingIntent.getStringExtra("yearOut"));

            if(Integer.parseInt(incomingIntent.getStringExtra("numberPerson")) > 1)
                guest = "Guests";

            if(Integer.parseInt(incomingIntent.getStringExtra("numberRoom"))>1)
                room = "Rooms";

            numberPersonSearch.setText(incomingIntent.getStringExtra("numberPerson")+" "+guest);
            numberRoomSearch.setText(incomingIntent.getStringExtra("numberRoom")+" "+room);
            hourInSearch.setText(h+"."+m);
            hourOutSearch.setText(h+"."+m);
            String saveDateIn, saveDateOut;
            saveDateIn = incomingIntent.getStringExtra("dateIn")+"="+incomingIntent.getStringExtra("monthIn")+"="+incomingIntent.getStringExtra("yearIn");
            saveDateOut = incomingIntent.getStringExtra("dateOut")+"="+incomingIntent.getStringExtra("monthOut")+"="+incomingIntent.getStringExtra("yearOut");
            sharedPreference.saveDateIn(SearchResult.this, saveDateIn);
            sharedPreference.saveDateOut(SearchResult.this, saveDateOut);
            sharedPreference.saveHourIn(SearchResult.this, hourInSearch.getText().toString());
            sharedPreference.saveHourOut(SearchResult.this, hourOutSearch.getText().toString());
        }

        if(className.equals("com.example.bobobox.bobobox.BookingHour")) {
            dateInSearch.setText(incomingIntent.getStringExtra("hourInDay").substring(0,3)+", "+incomingIntent.getStringExtra("hourDateIn"));
            dateOutSearch.setText(incomingIntent.getStringExtra("hourOutDay").substring(0,3)+", "+incomingIntent.getStringExtra("hourDateOut"));
            monthYearInSearch.setText(months[Integer.parseInt(incomingIntent.getStringExtra("hourMonth"))]+", "+incomingIntent.getStringExtra("hourYear"));
            monthYearOutSearch.setText(months[Integer.parseInt(incomingIntent.getStringExtra("hourMonth"))]+", "+incomingIntent.getStringExtra("hourYear"));

            if(Integer.parseInt(incomingIntent.getStringExtra("numberPerson")) > 1)
                guest = "Guests";

            if(Integer.parseInt(incomingIntent.getStringExtra("numberRoom"))>1)
                room = "Rooms";

            numberPersonSearch.setText(incomingIntent.getStringExtra("numberPerson")+" "+guest);
            numberRoomSearch.setText(incomingIntent.getStringExtra("numberRoom")+" "+room);
            hourInSearch.setText(incomingIntent.getStringExtra("hourIn"));
            hourOutSearch.setText(incomingIntent.getStringExtra("hourOut"));
            String dateHour =  incomingIntent.getStringExtra("hourDateIn")+"="+incomingIntent.getStringExtra("hourMonth")+"="+incomingIntent.getStringExtra("hourYear");
            sharedPreference.saveDateHour(SearchResult.this, dateHour);
            sharedPreference.saveHourIn(SearchResult.this, incomingIntent.getStringExtra("hourIn"));
            sharedPreference.saveHourOut(SearchResult.this, incomingIntent.getStringExtra("hourOut"));
        }
        city = incomingIntent.getStringExtra("city");
        roomPosition = incomingIntent.getStringExtra("roomPosition");
    }

    private void initialVariable() {
        incomingIntent = getIntent();
        className = incomingIntent.getStringExtra("class");

        dateInSearch = (TextView) findViewById(R.id.boboboxDateInSearch);
        dateOutSearch= (TextView) findViewById(R.id.boboboxDateOutSearch);
        monthYearInSearch = (TextView) findViewById(R.id.boboboxMonthYearInSearch);
        monthYearOutSearch = (TextView) findViewById(R.id.boboboxMonthYearOutSearch);
        hourInSearch = (TextView) findViewById(R.id.boboboxHourInSearch);
        hourOutSearch = (TextView) findViewById(R.id.boboboxHourOutSearch);
        numberPersonSearch = (TextView) findViewById(R.id.boboboxNumberPersonSearch);
        numberRoomSearch = (TextView) findViewById(R.id.boboboxNumberRoomSearch);

        recyclerView = (RecyclerView) findViewById(R.id.boboboxRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        boboboxLists = new ArrayList<>();

        if(mHour < 10)
            h = "0"+String.valueOf(mHour);
        else
            h = String.valueOf(mHour);

        if(mMinute < 10)
            m = "0"+String.valueOf(mMinute);
        else
            m = String.valueOf(mMinute);

        nextToBC = (RelativeLayout) findViewById(R.id.nextToBC);
        nextToBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchResult.this, DetailRoom.class);
                startActivity(intent);
            }
        });
    }


}
