package com.shy;

class Ingredient {

    /**
     * declare the datatype
     */


    private final String name;
    private final double price;
    final private int needed;


    /**
     * Overloaded constructor of Ingredient to store new name and new price of new object
     */

    Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
        this.needed = 0;
    }


    /**
     *Overloaded constructor of Ingredient to store new name and new price and new needed of new object
     */

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

    /**
     * getting all the ingredient name, price, needed and return
     */

    String GetName() {
        return this.name;
    }

    double GetPrice() {
        return this.price;
    }

    int GetNeeded() {
        return this.needed;
    }


    /**
     *Turn the value of ingredient into string and print out
     */

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", needed=" + needed +
                '}';
    }
}
