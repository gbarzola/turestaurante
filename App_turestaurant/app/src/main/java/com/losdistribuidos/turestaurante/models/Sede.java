package com.losdistribuidos.turestaurante.models;

/**
 * Created by hadpa on 06/05/2018.
 */

public class Sede {
    private int id;
    private String direccion;
    private String cantidad_de_mesas;

    public Sede(int id, String direccion, String cantidad_de_mesas) {
        this.id = id;
        this.direccion = direccion;
        this.cantidad_de_mesas = cantidad_de_mesas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCantidad_de_mesas() {
        return cantidad_de_mesas;
    }

    public void setCantidad_de_mesas(String cantidad_de_mesas) {
        this.cantidad_de_mesas = cantidad_de_mesas;
    }
}
