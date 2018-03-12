package com.example.bobobox.bobobox.Data;

/**
 * Created by Unknown on 3/5/2018.
 */

public class Booking {
    private String id;
    private String id_jenis_booking;
    private String id_user;
    private String id_room;
    private String email;
    private String no_telp;
    private String check_in;
    private String check_out;
    private String breakfast;
    private String uniq_code;

    public Booking(String id_jenis_booking, String id_user, String id_room, String email, String no_telp, String check_in, String check_out, String breakfast, String uniq_code) {
        this.id_jenis_booking = id_jenis_booking;
        this.id_user = id_user;
        this.id_room = id_room;
        this.email = email;
        this.no_telp = no_telp;
        this.check_in = check_in;
        this.check_out = check_out;
        this.breakfast = breakfast;
        this.uniq_code = uniq_code;
    }

    public String getId(){
        return id;
    }
}
