package com.sourcey.turestaurante.Entity;

/**
 * Created by Usuario on 8/04/2018.
 */

public class Dishes {
    private int id;
    private String dishes_name, dishes_image;
    private Double dishes_cost;
    private int dishes_quantity, id_restaurant;

    public Dishes(){

    }

    public Dishes(int id, String dishes_name, String dishes_image, Double dishes_cost, int dishes_quantity, int id_restaurant){
        this.id = id;
        this.dishes_name = dishes_name;
        this.dishes_image = dishes_image;
        this.dishes_cost = dishes_cost;
        this.dishes_quantity = dishes_quantity;
        this.id_restaurant = id_restaurant;
    }


    public int getId() {
        return id;
    }

    public String getDishes_name() {
        return dishes_name;
    }

    public String getDishes_image() {
        return dishes_image;
    }

    public Double getDishes_cost() {
        return dishes_cost;
    }

    public int getDishes_quantity() {
        return dishes_quantity;
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDishes_name(String dishes_name) {
        this.dishes_name = dishes_name;
    }

    public void setDishes_image(String dishes_image) {
        this.dishes_image = dishes_image;
    }

    public void setDishes_cost(Double dishes_cost) {
        this.dishes_cost = dishes_cost;
    }

    public void setDishes_quantity(int dishes_quantity) {
        this.dishes_quantity = dishes_quantity;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }
}
