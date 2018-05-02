package com.shy;

class Ingredient {
    private String name;
    private double price;
    private int needed;
    Ingredient(String name, double price){
        this.name = name;
        this.price = price;
        this.needed = needed;
    }
    Ingredient(String name, int needed){
        this.name = name;
        this.needed = needed;
    }

    String GetName(){
        return this.name;
    }
    double GetPrice(){
        return this.price;
    }
    int GetNeeded() {
        return this.needed;
    }


}
