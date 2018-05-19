package com.shy;

import java.util.ArrayList;

public class Product implements Cloneable {

    private String name;
    private double price;
    private int quantity;

    private ArrayList<Ingredient> ingredients;
    // constructor with custom number of product
    // constructor for default 1 product
    Product(String name, double price, ArrayList<Ingredient> ingredients)
    {
        this.name = name;
        this.price = price;
        this.quantity = 1;
        this.ingredients = ingredients;
    }
    String getName()
    {
        return this.name;
    }
    double getPrice()
    {
        return this.price;
    }

    void setQuantity(int i) {
        this.quantity = i;
    }
    int getQuantity()
    {
        return this.quantity;
    }
    ArrayList<Ingredient> getIngredients()
    {
        return this.ingredients;
    }
    void addQuantity(int add)
    {
        this.quantity += add;
    }
    public int reduceQuantityAndReturn(int reduce) {
        if (this.quantity <= reduce)
        {
            return -1;
        }
        else return reduce - this.quantity;
    }

    public Product clone() throws CloneNotSupportedException {
        Product cloneObj = (Product) super.clone();
        cloneObj.ingredients = this.ingredients;
        cloneObj.quantity = 1;
        cloneObj.name = this.name;
        cloneObj.price = this.price;
        return cloneObj;
    }
}
