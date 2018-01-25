package com.example.bobobox.bobobox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/**
 * Created by clown on 12/21/2017.
 */

public class Main extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    private Button btnToSignIn;
    private Button btnToSignUp;
    private GoogleApiClient googleApiClient;

    private Intent intent;

    LoginButton fbLoginButton;
    Button fbLogin;
    Button googleLogin;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.main_layout);

        initialVariable();
        facebookSetup();

        fbLogin.setOnClickListener(this);

        googleLogin.setOnClickListener(this);

        btnToSignIn.setOnClickListener(this);

        btnToSignUp.setOnClickListener(this);
    }

    private void facebookSetup() {
        callbackManager = CallbackManager.Factory.create();
        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    private void initialVariable() {
        btnToSignIn = (Button) findViewById(R.id.btnToSignIn);
        btnToSignUp = (Button) findViewById(R.id.btnToSignUp);

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();

        fbLoginButton = (LoginButton) findViewById(R.id.btnSignInFacebook);
        fbLogin = (Button) findViewById(R.id.btnSignInFacebookLink);

        googleLogin = (Button) findViewById(R.id.btnSignInGmail);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 9001){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            googleHandleResult(result);
        } else
            callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void googleSignIn(){
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent, 9001);
    }

//    private void googleSignOut(){
//
//    }

    private void googleHandleResult(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            String name = account.getDisplayName();
            String email = account.getEmail();
            String img_url = account.getPhotoUrl().toString();
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnSignInFacebookLink:
                fbLoginButton.performClick();
                break;
            case R.id.btnSignInGmail:
                googleSignIn();
                break;
            case R.id.btnToSignIn:
                intent = new Intent(Main.this, SignIn.class);
                startActivity(intent);
                break;
            case R.id.btnToSignUp:
                intent = new Intent(Main.this, SignUp.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

//    private void updateUI(boolean isLogin){
//        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
//            @Override
//            public void onResult(@NonNull Status status) {
//
//            }
//        });
//
//    }
}
