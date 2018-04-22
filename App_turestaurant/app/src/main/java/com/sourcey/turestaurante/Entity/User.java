package com.sourcey.turestaurante.Entity;

/**
 * Created by Usuario on 7/04/2018.
 */

class User {
    private int id;
    private String name;
    private String address;
    private String email;
    private String mobile;
    private String password;
    private String confirmpass;

    public User(int id, String name, String address, String email, String mobile, String password, String confirmpass)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.confirmpass = confirmpass;
    }

    public int getId()
    {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }

    public String getMobile(){
        return mobile;
    }

    public String getPassword(){
        return  password;
    }

    public String getConfirmpass(){
        return confirmpass;
    }
}
