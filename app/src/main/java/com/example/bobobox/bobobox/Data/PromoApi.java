package com.example.bobobox.bobobox.Data;

/**
 * Created by Unknown on 3/11/2018.
 */

public class PromoApi {
    private String roomName;
    private String city;
    private String percent;
    private String image;
    private String oldPrice;
    private String newPrice;

    public PromoApi(String roomName, String city, String percent, String image, String oldPrice, String newPrice) {
        this.roomName = roomName;
        this.city = city;
        this.percent = percent;
        this.image = image;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getCity() {
        return city;
    }

    public String getPercent() {
        return percent;
    }

    public String getImage() {
        return image;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }
}
