package com.losdistribuidos.turestaurante.models;

/**
 * Created by hadpa on 06/05/2018.
 */

public class SedeRestaurante {
    private int id;
    private String direccion;
    private int cantidad_de_mesas;
    private int restaurant_id;

    public SedeRestaurante(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
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

    public int getCantidad_de_mesas() {
        return cantidad_de_mesas;
    }

    public void setCantidad_de_mesas(int cantidad_de_mesas) {
        this.cantidad_de_mesas = cantidad_de_mesas;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
