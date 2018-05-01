package com.shy;

class Ingredient {
    private String name;
    private double price;

    Ingredient(String name, double price){
        this.name = name;
        this.price = price;
    }

    String GetName(){
        return this.name;
    }
    double GetPrice(){
        return this.price;
    }


}
