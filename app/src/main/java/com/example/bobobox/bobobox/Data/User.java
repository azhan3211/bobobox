package com.example.bobobox.bobobox.Data;

/**
 * Created by Unknown on 2/5/2018.
 */

public class User {
    String id;
    String nama;
    String username;
    String email;
    Character jenis_kelamin;
    String no_telp;

    public User(String id, String nama, String username, String email, Character jenis_kelamin, String no_telp) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.email = email;
        this.jenis_kelamin = jenis_kelamin;
        this.no_telp = no_telp;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Character getJenis_kelamin() {
        return jenis_kelamin;
    }

    public String getNo_telp() {
        return no_telp;
    }
}
