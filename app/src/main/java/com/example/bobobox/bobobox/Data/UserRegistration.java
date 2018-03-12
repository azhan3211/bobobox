package com.example.bobobox.bobobox.Data;

/**
 * Created by Unknown on 1/30/2018.
 */

public class UserRegistration {

    private int id;
    private String fullName;
    private String username;
    private String phone;
    private String email;
    private String password;

    public UserRegistration(String fullName, String username, String phone, String email, String password) {
        this.fullName = fullName;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }
}
