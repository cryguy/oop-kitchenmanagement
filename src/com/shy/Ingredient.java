package com.shy;

public class Ingredient {
    private String name;
    private double price;

    public Ingredient(String name, double price){
        this.name = name;
        this.price = price;
    }
    public String GetName(){
        return this.name;
    }
    public double GetPrice(){
        return this.price;
    }


}
