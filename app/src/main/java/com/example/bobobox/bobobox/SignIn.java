package com.example.bobobox.bobobox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by clown on 12/21/2017.
 */

public class SignIn extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button signIn;

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);

        username = (EditText) findViewById(R.id.usernameTV);
        password = (EditText) findViewById(R.id.passwordTV);

        signIn   = (Button) findViewById(R.id.btnSignIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(SignIn.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
