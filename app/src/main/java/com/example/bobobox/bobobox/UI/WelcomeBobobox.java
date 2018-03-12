package com.example.bobobox.bobobox.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.bobobox.bobobox.R;

/**
 * Created by clown on 12/21/2017.
 */

public class WelcomeBobobox extends AppCompatActivity{

    private TextView welcome;
    private TextView skip;

    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_bobobox_layout);

        welcome = (TextView) findViewById(R.id.welcomeTV);
        skip = (TextView) findViewById(R.id.skipTV);

        welcome.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(WelcomeBobobox.this, SignIn.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
