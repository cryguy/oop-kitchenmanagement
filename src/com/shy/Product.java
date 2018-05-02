package com.shy;

import java.util.ArrayList;

public class Product {

    private String name = "";
    //private int number = 0;
    private double price = 0;
    private int quantity = 0;

    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    Product(String name, double price, int quantity, ArrayList<Ingredient> ingredients)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

}
