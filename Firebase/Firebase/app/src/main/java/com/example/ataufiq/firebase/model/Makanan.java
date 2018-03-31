package com.example.ataufiq.firebase.model;

/**
 * Created by ataufiq on 20/03/18.
 */

public class Makanan {

    private String idFood;
    private String foodName;
    private String typeFood;

    public Makanan(){

    }

    public Makanan(String idFood, String foodName, String typeFood) {
        this.idFood = idFood;
        this.foodName = foodName;
        this.typeFood = typeFood;
    }

    public String getIdFood() {
        return idFood;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getTypeFood() {
        return typeFood;
    }
}
