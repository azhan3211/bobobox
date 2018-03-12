package com.example.bobobox.bobobox.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bobobox.bobobox.Data.BoboboxDataInterface;
import com.example.bobobox.bobobox.Data.UserRegistration;
import com.example.bobobox.bobobox.R;
import com.example.bobobox.bobobox.Service.BoboboxRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by clown on 12/21/2017.
 */

public class SignUp extends AppCompatActivity {

    private TextView fullName;
    private TextView username;
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

        fullName   = (TextView) findViewById(R.id.fullNameupTV);
        username   = (TextView) findViewById(R.id.usernameupTV);
        email      = (TextView) findViewById(R.id.emailupTV);
        phone      = (TextView) findViewById(R.id.phoneupTV);
        password   = (TextView) findViewById(R.id.passwordupTV);
        rePassword = (TextView) findViewById(R.id.repasswordupTV);

        signUp = (Button) findViewById(R.id.btnSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString().equals(rePassword.getText().toString())){
                    UserRegistration userRegistration = new UserRegistration(
                            fullName.getText().toString(),
                            username.getText().toString(),
                            phone.getText().toString(),
                            email.getText().toString(),
                            password.getText().toString()
                    );
                    sendData(userRegistration);
                } else {
                    Toast.makeText(SignUp.this, "Your password doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendData(UserRegistration userRegistration) {
        BoboboxRetrofit builder = new BoboboxRetrofit();
        Retrofit retrofit = builder.syncBobobox();
        BoboboxDataInterface boboboxDataInterface = retrofit.create(BoboboxDataInterface.class);
        Call<UserRegistration> call = boboboxDataInterface.setBoboboxUserRegistration(userRegistration);
        call.enqueue(new Callback<UserRegistration>() {
            @Override
            public void onResponse(Call<UserRegistration> call, Response<UserRegistration> response) {
                UserRegistration result = response.body();
                Log.d("id user baru daftar", String.valueOf(result.getId()));
            }

            @Override
            public void onFailure(Call<UserRegistration> call, Throwable t) {

            }
        });
        intent = new Intent(SignUp.this, Validation.class);
        startActivity(intent);
    }


}
