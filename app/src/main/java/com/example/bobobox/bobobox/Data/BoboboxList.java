package com.example.bobobox.bobobox.Data;

/**
 * Created by ganteun unikom eka on 12/29/2017.
 */

public class BoboboxList {

    private int id;
    private String nama_hotel;
    private Double rating;
    private String harga;
    private String alamat;
    private String negara;
    private String position;

    public BoboboxList(int id, String nama_hotel, Double rating, String harga, String alamat, String negara, String position) {
        this.id = id;
        this.nama_hotel = nama_hotel;
        this.rating = rating;
        this.harga = harga;
        this.alamat = alamat;
        this.negara = negara;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getNamaHotel() {
        return nama_hotel;
    }

    public Double getRating() {
        return rating;
    }

    public String getHarga() {
        return harga;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNegara() {
        return negara;
    }

    public String getPosition() {
        return position;
    }
}
