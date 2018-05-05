package com.shy;

import java.util.ArrayList;

public class ProductManagement {
    // TODO : ADD method to add stock
    // StockManagement is an object that contains the array of Stocks
    static ArrayList<Product> products = new ArrayList<>();
    private static ProductManagement instance = null;
    protected ProductManagement() {}
    /*
    Prevents us from making more than 1 instance and causing problems
    -- SINGLETON
     */
    public synchronized static ProductManagement getInstance() {
        if(instance == null) {
            instance = new ProductManagement();
        }
        return instance;
    }
}
