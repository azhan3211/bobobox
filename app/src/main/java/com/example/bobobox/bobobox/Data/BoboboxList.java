package com.example.bobobox.bobobox.Data;

/**
 * Created by ganteun unikom eka on 12/29/2017.
 */

public class BoboboxList {

    private String id;
    private String nama_hotel;
    private Double rating;
    private Double harga;
    private String alamat;
    private String negara;
    private String position;

    public BoboboxList(String id, String nama_hotel, Double rating, Double harga, String alamat, String negara, String position) {
        this.id = id;
        this.nama_hotel = nama_hotel;
        this.rating = rating;
        this.harga = harga;
        this.alamat = alamat;
        this.negara = negara;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public String getNamaHotel() {
        return nama_hotel;
    }

    public Double getRating() {
        return rating;
    }

    public Double getHarga() {
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
