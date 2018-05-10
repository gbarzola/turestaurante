package com.losdistribuidos.turestaurante.models;

/**
 * Created by Usuario on 1/05/2018.
 */

public class Reservation {

    private int id_reservation, iddish, iduser;

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getIddish() {
        return iddish;
    }

    public void setIddish(int iddish) {
        this.iddish = iddish;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
}
