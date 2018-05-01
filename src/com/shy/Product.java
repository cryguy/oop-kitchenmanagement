package com.shy;

import java.util.ArrayList;

public class Product {

    /*

        todo : add method to change value of quantity
        todo : add bool method to check if item is available - dunno if we should do it here or in product

     */



    private String name = "";
    private int number = 0;
    private double price = 0;
    private int quantity = 0;

    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    public void addIngredient(Ingredient i) {
        this.ingredients.add(i);
    }
    public Product(String name, int number, double price, int quantity,ArrayList<Ingredient> ingredients)
    {
        this.name = name;
        this.number = number;
        this.price = price;
        this.quantity = quantity;
        this.ingredients = ingredients;
    }
    public String GetName()
    {
        return this.name;
    }
    public int getNumber()
    {
        return this.number;
    }
    public double GetPrice()
    {
        return this.price;
    }
    public int GetQuantity()
    {
        return this.quantity;
    }
    public ArrayList<Ingredient> GetIngredients()
    {
        return this.ingredients;
    }


}
