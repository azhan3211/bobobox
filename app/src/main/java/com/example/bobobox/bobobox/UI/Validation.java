package com.example.bobobox.bobobox.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.example.bobobox.bobobox.R;


/**
 * Created by Unknown on 1/17/2018.
 */

public class Validation extends AppCompatActivity {

    PinEntryEditText pinEntryEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_validation);
        pinEntryEditText = (PinEntryEditText) findViewById(R.id.boboboxVCPE);
        pinEntryEditText.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() {
            @Override
            public void onPinEntered(CharSequence str) {
                if(str.length() == 6){
                    Intent intent = new Intent(Validation.this, WelcomeBobobox.class);
                    startActivity(intent);
                }
            }
        });
    }
}
