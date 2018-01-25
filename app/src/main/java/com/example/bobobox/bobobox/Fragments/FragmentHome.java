package com.example.bobobox.bobobox.Fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bobobox.bobobox.BookingDate;
import com.example.bobobox.bobobox.BookingHour;
import com.example.bobobox.bobobox.R;

import static com.example.bobobox.bobobox.R.id.textView;

/**
 * Created by Unknown on 12/24/2017.
 */

public class FragmentHome extends Fragment {

    private RelativeLayout boboboxLite;
    private RelativeLayout boboboxStay;
    private Intent intent;

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
        imagePromo1 = (ImageView) view.findViewById(R.id.boboboxImagePromoIV1);
        imagePromo2 = (ImageView) view.findViewById(R.id.boboboxImagePromoIV2);
        imagePromo3 = (ImageView) view.findViewById(R.id.boboboxImagePromoIV3);

        oldPrice1 = (TextView) view.findViewById(R.id.boboboxOldPricePromoTV1);
        oldPrice2 = (TextView) view.findViewById(R.id.boboboxOldPricePromoTV2);
        oldPrice3 = (TextView) view.findViewById(R.id.boboboxOldPricePromoTV3);

        oldPrice1.setPaintFlags(oldPrice1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        oldPrice2.setPaintFlags(oldPrice2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        oldPrice3.setPaintFlags(oldPrice3.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        imagePromo1.setImageBitmap(roundedImage(images[0]));
        imagePromo2.setImageBitmap(roundedImage(images[1]));
        imagePromo3.setImageBitmap(roundedImage(images[2]));


    }

    private Bitmap roundedImage(int imagesR){
        Bitmap mbitmap = ((BitmapDrawable) getResources().getDrawable(imagesR)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())), 20, 20, mpaint);// Round Image Corner 100 100 100 100
        return imageRounded;
    }
}
