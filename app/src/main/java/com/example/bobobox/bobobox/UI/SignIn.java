package com.example.bobobox.bobobox.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bobobox.bobobox.Data.BoboboxDataInterface;
import com.example.bobobox.bobobox.Data.LoginSessoin;
import com.example.bobobox.bobobox.Data.User;
import com.example.bobobox.bobobox.R;
import com.example.bobobox.bobobox.Service.BoboboxRetrofit;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by clown on 12/21/2017.
 */

public class SignIn extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button signIn;

    private Intent intent;
    private ProgressDialog loading;
    private LoginSessoin loginSession = new LoginSessoin();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);

        if(loginSession.getUsernameSession(SignIn.this) != null){
            intent = new Intent(SignIn.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

        username = (EditText) findViewById(R.id.usernameTV);
        password = (EditText) findViewById(R.id.passwordTV);

        signIn   = (Button) findViewById(R.id.btnSignIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading = ProgressDialog.show(SignIn.this, null, "Wait...", true, false);
                checkToServer();
            }
        });
    }

    private void checkToServer() {
        BoboboxRetrofit builder = new BoboboxRetrofit();
        Retrofit retrofit = builder.syncBobobox();
        BoboboxDataInterface boboboxDataInterface = retrofit.create(BoboboxDataInterface.class);
        Call<User> call = boboboxDataInterface.getUser(username.getText().toString(), password.getText().toString());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    User result = response.body();
                    if(result.getId() != null){
                        loading.dismiss();
                        loginSession.save(SignIn.this, result.getId(), result.getUsername(), result.getEmail(), result.getNo_telp());
                        intent = new Intent(SignIn.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK );
                        startActivity(intent);
                        finish();
                    } else {
                        loading.dismiss();
                        Toast.makeText(SignIn.this, "Username and password are no match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
