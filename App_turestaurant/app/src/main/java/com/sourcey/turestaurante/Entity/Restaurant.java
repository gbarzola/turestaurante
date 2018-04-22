package com.sourcey.turestaurante.Entity;

/**
 * Created by Usuario on 8/04/2018.
 */

public class Restaurant {
    private int photo;
    private String name;
    private String address;
    private String mobile;

    public Restaurant(){

    }

    public Restaurant(int photo, String name, String address, String mobile){
        this.photo = photo;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public int getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
