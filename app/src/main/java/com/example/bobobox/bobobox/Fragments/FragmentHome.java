package com.example.bobobox.bobobox.Fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bobobox.bobobox.Adapter.PromoAdapter;
import com.example.bobobox.bobobox.Data.PromoApi;
import com.example.bobobox.bobobox.UI.BookingDate;
import com.example.bobobox.bobobox.UI.BookingHour;
import com.example.bobobox.bobobox.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Unknown on 12/24/2017.
 */

public class FragmentHome extends Fragment {

    private RelativeLayout boboboxLite;
    private RelativeLayout boboboxStay;
    private Intent intent;
    private RecyclerView promoRV;
    private RecyclerView.Adapter promoAdapter;
    private List<PromoApi> promos;
    private PromoApi promo;

    ImageView imagePromo1, imagePromo2, imagePromo3;
    TextView oldPrice1, oldPrice2, oldPrice3;

    private Integer[] images = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};

    public FragmentHome() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        initialVariable(v);
        boboboxLite = (RelativeLayout) v.findViewById(R.id.boboboxLiteLL);

        boboboxLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), BookingHour.class);
                startActivity(intent);
            }
        });

        boboboxStay = (RelativeLayout) v.findViewById(R.id.boboboxStayLL);

        boboboxStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), BookingDate.class);
                startActivity(intent);
            }
        });
        return v;
    }

    private void initialVariable(View view) {
        promoRV = (RecyclerView) view.findViewById(R.id.boboboxFHPromoRV);
        promoRV.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayout.HORIZONTAL, false));
        promos = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            promo = new PromoApi(
                    "Bobobox #"+(i+1),
                    "City "+(i+1),
                    "20%",
                    null,
                    "200000",
                    "160000"
            );
            promos.add(promo);
        }
        promoAdapter = new PromoAdapter(getActivity().getApplicationContext(), promos);
        promoRV.setAdapter(promoAdapter);
    }
}
