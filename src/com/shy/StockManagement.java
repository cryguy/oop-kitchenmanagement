package com.shy;

import java.util.ArrayList;

public class StockManagement {
    // TODO : ADD method to add stock
    // StockManagement is an object that contains the array of Stocks
    static ArrayList<Stock> stocks = new ArrayList<>();
    private static StockManagement instance = null;
    protected StockManagement () {}
    /*
    Prevents us from making more than 1 instance and causing problems
    -- SINGLETON
     */
    public synchronized static StockManagement getInstance() {
        if(instance == null) {
            instance = new StockManagement();
        }
        return instance;
    }
    void PrintStocks(){
        for (Stock i : stocks)
        {
            System.out.println(i.getIngredient().GetName() + " " + i.getLeft());
        }
    }
    void ReduceQuantity(Product product) {
        for (Ingredient i : product.getIngredients())
            for (Stock j : stocks)
                if (j.getIngredient().GetName().equals(i.GetName())) {
                    j.reduceLeft(i.GetNeeded()*product.getQuantity()); // reduce by number of quantity needed * number of product ordered
                    break; // break out of 1 for loop as we found it already, don't need to go to the next if we found it
                }
    }
}
