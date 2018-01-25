package com.example.bobobox.bobobox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Unknown on 1/13/2018.
 */

public class BookingConfirmationStep2 extends AppCompatActivity {

    Button nextStepBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_confirmation_step2);
        nextStepBtn = (Button) findViewById(R.id.boboboxBCNextStep2Btn);

        nextStepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookingConfirmationStep2.this, BookingConfirmationStep3.class);
                startActivity(intent);
            }
        });
    }
}
