package com.shy;
import java.util.ArrayList;

public class Product implements Cloneable {


    /**
     * declare the variable of product
     */

    private String name;
    private double price;
    private int quantity;

    private ArrayList<Ingredient> ingredients;
    // constructor with custom number of product
    // constructor for default 1 product


    /**
     *overload constructor to receive the value from user
     */
    Product(String name, double price, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
        this.ingredients = ingredients;
    }


    /**
     *get name of product
     * @return name of the product
     */
    String getName() {
        return this.name;
    }


    /**
     *get price of product
     * @return price of product
     */
    double getPrice() {
        return this.price;
    }

    /**
     *get quantity of product
     * @return quantity of product
     */
    int getQuantity()
    {
        return this.quantity;
    }

    /**
     * set the quantity of product
     *
     * @return quantity of product
     */

    void setQuantity(int i) {
        this.quantity = i;
    }

    /**
     *get the ingredients of product
     * @return the ingredient needed by the product
     */
    ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }


    /**
     *add the quantity of product
     */
    void addQuantity(int add) {
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
