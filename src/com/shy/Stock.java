package com.shy;

class Stock extends Ingredient {

    /*

    Not sure if we want to use Inheritance here,
    might be better to just use the object because we might need to add this to Product?
    Or we can just make a method to return an Object of Ingredient?

    */
    private int left;

    Stock(String name, double price, int left) {
        super(name, price);
        this.left = left;
        //this.ingredient = ingredient;
    }
    int getLeft() {
        return this.left;
    }

    String getName() {
        return super.GetName();
    }

    double getPrice() {
        return super.GetPrice();
    }

    void reduceLeft(int reduce) {
        this.left -= reduce;
    }
    void addLeft(int add) { this.left += add; }

    Ingredient ingredient() {
        return this;
    }
}