package com.example.bobobox.bobobox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by clown on 12/21/2017.
 */

public class SignUp extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView phone;
    private TextView password;
    private TextView rePassword;
    private Button signUp;

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        name       = (TextView) findViewById(R.id.nameupTV);
        email      = (TextView) findViewById(R.id.emailupTV);
        phone      = (TextView) findViewById(R.id.phoneupTV);
        password   = (TextView) findViewById(R.id.passwordTV);
        rePassword = (TextView) findViewById(R.id.repasswordupTV);

        signUp = (Button) findViewById(R.id.btnSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(password.getText().toString().equals(rePassword.getText().toString())){
                    // Do something here
//                } else {
//                    Toast.makeText(this, "Your password doesn't match", Toast.LENGTH_SHORT).show();
//                }
                intent = new Intent(SignUp.this, Validation.class);
                startActivity(intent);
            }
        });
    }
}
