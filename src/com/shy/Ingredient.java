package com.shy;

class Ingredient {
    private final String name;
    private final double price;
    final private int needed;
    Ingredient(String name, double price){
        this.name = name;
        this.price = price;
        this.needed = 0;
    }

    Ingredient(String name, double price, int needed) {
        this.name = name;
        this.price = price;
        this.needed = needed;
    }
// --Commented out by Inspection START (11/5/2018 8:33 AM):
//    Ingredient(String name, int needed){
//        this.name = name;
//        this.price = 0;
//        this.needed = needed;
//    }
// --Commented out by Inspection STOP (11/5/2018 8:33 AM)

    String GetName(){
        return this.name;
    }
    double GetPrice(){
        return this.price;
    }
    int GetNeeded() {
        return this.needed;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", needed=" + needed +
                '}';
    }
}
