package com.example.ataufiq.firebase;

/**
 * Created by ataufiq on 20/03/18.
 */

public class Makanan {

    private String id_food;
    private String foodName;
    private String typeFood;

    public Makanan(String id_food, String foodName, String typeFood) {
        this.id_food = id_food;
        this.foodName = foodName;
        this.typeFood = typeFood;
    }

    public String getId_food() {
        return id_food;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getTypeFood() {
        return typeFood;
    }
}
