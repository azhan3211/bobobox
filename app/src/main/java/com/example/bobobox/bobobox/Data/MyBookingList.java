package com.example.bobobox.bobobox.Data;

/**
 * Created by Unknown on 1/16/2018.
 */

public class MyBookingList {
    private String boboboxName;
    private String boboboxType;
    private String boboboxCheckIn;
    private String boboboxCheckOut;

    public MyBookingList(String boboboxName, String boboboxType, String boboboxCheckIn, String boboboxCheckOut) {
        this.boboboxName = boboboxName;
        this.boboboxType = boboboxType;
        this.boboboxCheckIn = boboboxCheckIn;
        this.boboboxCheckOut = boboboxCheckOut;
    }

    public String getBoboboxName() {
        return boboboxName;
    }

    public String getBoboboxType() {
        return boboboxType;
    }

    public String getBoboboxCheckIn() {
        return boboboxCheckIn;
    }

    public String getBoboboxCheckOut() {
        return boboboxCheckOut;
    }
}
