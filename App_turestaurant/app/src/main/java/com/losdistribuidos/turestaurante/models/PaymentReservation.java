package com.losdistribuidos.turestaurante.models;

/**
 * Created by Usuario on 1/05/2018.
 */

public class PaymentReservation {

    private int id_pr, id_pt, id_reservation;
    private float total_amount;
    private String concept;

    public int getId_pr() {
        return id_pr;
    }

    public void setId_pr(int id_pr) {
        this.id_pr = id_pr;
    }

    public int getId_pt() {
        return id_pt;
    }

    public void setId_pt(int id_pt) {
        this.id_pt = id_pt;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }
}
