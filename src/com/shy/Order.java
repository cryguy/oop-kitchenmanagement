package com.shy;

import java.util.ArrayList;
import java.util.Arrays;

public class Order {
    private ArrayList<Product> orderList = new ArrayList<>();

    Order() {}

    public void AddProduct(Product i) {
        boolean done = false;
        if (!this.orderList.isEmpty()) {
            for (int x = 0; x <= this.orderList.size(); x++) {
                if (this.orderList.get(x).getName().equals(i.getName())) {
                    done = true;
                    this.orderList.get(x).addQuantity(i.getQuantity());
                    break;
                }
            }
        }
        if (!done)
            this.orderList.add(i);
    }

    public String showOrder() {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (Product i : this.orderList) {
            ++counter;
            sb.append(counter).append(". ").append(i.getName()).append(" ").append(i.getQuantity()).append(" ").
                    append(i.getPrice() * i.getQuantity()).append("\n");
        }
        if (!this.orderList.isEmpty())
            return sb.toString();
        else return "NULL";
    }

    private boolean productAvailable(ArrayList<Stock> stocks, Product product){
        boolean[] t = new boolean[product.getIngredients().size()];
        int incre = 0;
        for (Ingredient i : product.getIngredients())
            for (Stock j : stocks)
                if (j.getIngredient().GetName().equals(i.GetName()))
                {
                        t[incre] = j.getLeft() >= i.GetNeeded();
                        incre++;
                }
        return areAllTrue(t);
        // change to this because previously it wont look thru all before returning true
        // if 1st is true, 2nd is false and 3rd is true, it will return true
    }
    private static boolean areAllTrue(boolean[] array)
    {
        for(boolean b : array) if(!b) return false;
        return true;
    }
    ArrayList<Product> showAllowedProduct(ArrayList<Stock> stocks, ArrayList<Product> products) {
        ArrayList<Product> returnproduct = new ArrayList<>();
        for (Product product : products) {
            if (productAvailable(stocks,product))
                returnproduct.add(product);
        }
        return returnproduct;
    }
}
