package com.losdistribuidos.turestaurante.models;

/**
 * Created by hadpa on 19/04/2018.
 */

public class Restaurant {

    private int id;
    private String razon_social;
    private String ruc;
    private String categoria;
    private String created_at;
    private String updated_at;
    private String avatar_url;

    public Restaurant(int id, String razon_social, String ruc, String categoria){//, String avatar_url) {
        this.id = id;
        this.razon_social = razon_social;
        this.ruc = ruc;
        this.categoria = categoria;
        //this.avatar_url = avatar_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
