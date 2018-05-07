package com.shy;

import java.util.ArrayList;

class ProductManagement {
    // TODO : ADD method to add stock
    // StockManagement is an object that contains the array of Stocks
    static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Product> availableProducts = new ArrayList<>();
    private static ProductManagement instance = null;

    private ProductManagement() {
    }
    /*
    Prevents us from making more than 1 instance and causing problems
    -- SINGLETON
     */
    synchronized static ProductManagement getInstance() {
        if(instance == null) {
            instance = new ProductManagement();
        }
        updateAvailable();
        return instance;
    }

    static ArrayList<Product> availableProducts() {
        for (Product i : availableProducts)
            i.setQuantity(1);
        return availableProducts;
    }

    private static boolean productAvailable(ArrayList<Stock> stocks, Product product) {
        //boolean[] t = new boolean[product.getIngredients().size()];
        //int incre = 0;
        for (Ingredient i : product.getIngredients())
            for (Stock j : stocks)
                if (j.GetName().equals(i.GetName())) {
                    if (!(j.getLeft() >= i.GetNeeded()))
                        return false;
                    break; // break out of 1 for loop as we found it already, don't need to go to the next if we found it
                }
        return true;
    }

    void PrintProduct() {
        int x = 0;
        for (Product i : products) {
            System.out.printf("%d\t %s\t\t  %.2f%n", ++x, i.getName(), i.getPrice());
            //System.out.println(++x + ". " + i.GetName() + " " + i.getLeft());
        }
    }
    private static ArrayList<Product> showAllowedProduct(ArrayList<Stock> stocks, ArrayList<Product> products) {
        ArrayList<Product> returnproduct = new ArrayList<>();
        for (Product product : products) {
            if (productAvailable(stocks, product))
                returnproduct.add(product);
        }
        return returnproduct;
    }

    static void updateAvailable() {
        for (Product i : availableProducts)
            i.setQuantity(1);
        availableProducts = showAllowedProduct(StockManagement.stocks, products);
    }

    void DeleteProduct(Product i) {
        products.remove(i);
    }

}
