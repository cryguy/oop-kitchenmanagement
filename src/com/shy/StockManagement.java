package com.shy;

import java.util.ArrayList;

class StockManagement {
    // TODO : ADD method to add stock
    // StockManagement is an object that contains the array of Stocks
    static ArrayList<Stock> stocks = new ArrayList<>();
    private static StockManagement instance = null;

    private StockManagement() {
    }
    /*
    Prevents us from making more than 1 instance and causing problems
    -- SINGLETON
     */
    synchronized static StockManagement getInstance() {
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
                    j.reduceLeft(i.GetNeeded() * product.getQuantity());
                    break;
                }
    }
}
