package com.example.bobobox.bobobox.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bobobox.bobobox.Data.LoginSessoin;
import com.example.bobobox.bobobox.R;
import com.example.bobobox.bobobox.UI.Main;

/**
 * Created by Unknown on 12/24/2017.
 */

public class FragmentMyProfil extends Fragment {

    TextView logoutButton;
    LoginSessoin loginSessoin = new LoginSessoin();
    TextView username,email,phone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_profil, container, false);
        initialVariable(v);
        setVariable();
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginSessoin.removeSession(getActivity());
                Intent intent = new Intent(getActivity(), Main.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return v;
    }

    private void setVariable() {
        username.setText(loginSessoin.getUsernameSession(getActivity().getApplicationContext()));
        email.setText(loginSessoin.getEmail(getActivity().getApplicationContext()));
        phone.setText(loginSessoin.getNoTelp(getActivity().getApplicationContext()));
    }

    private void initialVariable(View v){
        logoutButton = (TextView) v.findViewById(R.id.boboboxLogoutBtn);
        username = (TextView) v.findViewById(R.id.boboboxMPUsernameTV);
        email = (TextView) v.findViewById(R.id.boboboxMPEmailTV);
        phone = (TextView) v.findViewById(R.id.boboboxMPPhoneTV);
    }
}
