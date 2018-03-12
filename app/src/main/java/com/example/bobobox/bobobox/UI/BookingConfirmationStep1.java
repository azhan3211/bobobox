package com.example.bobobox.bobobox.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.bobobox.bobobox.Data.SharedPreference;
import com.example.bobobox.bobobox.R;

import java.text.SimpleDateFormat;

/**
 * Created by Unknown on 1/12/2018.
 */

public class BookingConfirmationStep1 extends AppCompatActivity implements View.OnClickListener {

    LinearLayout boboboxAnotherLL;
    RadioButton boboboxRBMyself, boboboxRBAnother;
    RadioGroup breakfastRG;
    Button nextStepBtn;
    SharedPreference sharedPreference = new SharedPreference();
    TextView boboboxCheckInDate, boboboxCheckOutDate;
    TextView boboboxCheckInHour, boboboxCheckOutHour;
    TextView boboboxPosition, boboboxGuest, boboboxName;
    ImageView boboboxTypeImage;

    private static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_confirmation_step1);
        initialVariable();

        boboboxRBMyself.setOnClickListener(this);
        boboboxRBAnother.setOnClickListener(this);
        nextStepBtn.setOnClickListener(this);
    }

    private void initialVariable() {
        String hourIn, hourOut;
        hourIn = sharedPreference.getHourInValue(BookingConfirmationStep1.this);
        hourOut = sharedPreference.getHourOutValue(BookingConfirmationStep1.this);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");

        boboboxAnotherLL = (LinearLayout) findViewById(R.id.boboboxBCAnotherLL);
        boboboxRBMyself = (RadioButton) findViewById(R.id.boboboxBCMyselfRB);
        boboboxRBAnother = (RadioButton) findViewById(R.id.boboboxBCAnotherRB);
        nextStepBtn = (Button) findViewById(R.id.boboboxBCNextStep1Btn);
        boboboxCheckInDate = (TextView) findViewById(R.id.boboboxBCDateInTV);
        boboboxCheckOutDate = (TextView) findViewById(R.id.boboboxBCDateOutTV);
        boboboxCheckInHour = (TextView) findViewById(R.id.boboboxBCHourInTV);
        boboboxCheckOutHour = (TextView) findViewById(R.id.boboboxBCHourOutTV);
        boboboxPosition = (TextView) findViewById(R.id.boboboxBCPositionTV);
        boboboxTypeImage = (ImageView) findViewById(R.id.boboboxBCPositionIV);
        boboboxGuest = (TextView) findViewById(R.id.boboboxBCGuestTV);
        boboboxName = (TextView) findViewById(R.id.boboboxBCNameTV);
        breakfastRG = (RadioGroup) findViewById(R.id.boboboxBCBreakfastRG);

        boboboxName.setText(getIntent().getStringExtra("namaHotel"));
        boboboxPosition.setText("Bobobox "+sharedPreference.getPosition(BookingConfirmationStep1.this));
        boboboxGuest.setText(sharedPreference.getNumberGuest(BookingConfirmationStep1.this));

        if(sharedPreference.getPosition(BookingConfirmationStep1.this).toLowerCase().equals("sky"))
            boboboxTypeImage.setImageResource(R.drawable.ic_room_type1);
        else
            boboboxTypeImage.setImageResource(R.drawable.ic_room_type2);

        boboboxCheckInHour.setText(hourIn+" WIB");
        boboboxCheckOutHour.setText(hourOut+" WIB");

        if(sharedPreference.getDateHourValue(BookingConfirmationStep1.this) != null){
            String[] splitDate;
            splitDate = sharedPreference.getDateHourValue(BookingConfirmationStep1.this).split("=");
            sharedPreference.saveDateIn(BookingConfirmationStep1.this, sharedPreference.getDateHourValue(BookingConfirmationStep1.this));
            sharedPreference.saveDateOut(BookingConfirmationStep1.this, sharedPreference.getDateHourValue(BookingConfirmationStep1.this));
            boboboxCheckInDate.setText(splitDate[0]+" "+months[Integer.parseInt(splitDate[1])]+" "+splitDate[2]);
            boboboxCheckOutDate.setText(splitDate[0]+" "+months[Integer.parseInt(splitDate[1])]+" "+splitDate[2]);
        }

        if(sharedPreference.getDateInValue(BookingConfirmationStep1.this) != null){
            String[] splitDateIn, splitDateOut;
            splitDateIn = sharedPreference.getDateInValue(BookingConfirmationStep1.this).split("=");
            splitDateOut = sharedPreference.getDateOutValue(BookingConfirmationStep1.this).split("=");
            boboboxCheckInDate.setText(splitDateIn[0]+" "+months[Integer.parseInt(splitDateIn[1])]+" "+splitDateIn[2]);
            boboboxCheckOutDate.setText(splitDateOut[0]+" "+months[Integer.parseInt(splitDateOut[1])]+" "+splitDateOut[2]);
        }

        sharedPreference.saveNameRoom(BookingConfirmationStep1.this, boboboxName.getText().toString());
        sharedPreference.saveBreakfast(BookingConfirmationStep1.this, "1");
        breakfastRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.boboboxBCBreakfastNoRB:
                        sharedPreference.saveBreakfast(BookingConfirmationStep1.this, "0");
                        break;
                    case R.id.boboboxBCBreakfastYesRB:
                        sharedPreference.saveBreakfast(BookingConfirmationStep1.this, "1");
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boboboxBCMyselfRB :
                boboboxAnotherLL.setVisibility(View.GONE);
                break;
            case R.id.boboboxBCAnotherRB :
                boboboxAnotherLL.setVisibility(View.VISIBLE);
                break;
            case R.id.boboboxBCNextStep1Btn :
                Intent intent = new Intent(BookingConfirmationStep1.this, BookingConfirmationStep2.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
