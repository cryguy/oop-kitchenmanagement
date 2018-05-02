package com.shy;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> orderList = new ArrayList<>();

    Order() {}

    public void AddProduct(Product i) {
        boolean done = false;
        if (!this.orderList.isEmpty()) {
            for (int x = 0; x <= this.orderList.size(); x++) {
                if (this.orderList.get(x).GetName().equals(i.GetName())) {
                    done = true;
                    this.orderList.get(x).AddQuantity(i.GetQuantity());
                    break;
                }
            }
        }
        if (!done)
            this.orderList.add(i);
    }

    public String ShowOrder() {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (Product i : this.orderList) {
            ++counter;
            sb.append(counter).append(". ").append(i.GetName()).append(" ").append(i.GetQuantity()).append(" ").
                    append(i.GetPrice() * i.GetQuantity()).append("\n");
            //1. Spaghetti 5 250 \n
        }
        if (!this.orderList.isEmpty())
            return sb.toString();
        else return "NULL";
    }

    private boolean ProductAvailable(ArrayList<Stock> stocks, Product product){
        boolean ret = false;
        for (Ingredient i : product.GetIngredients())
            for (Stock j : stocks)
                if (j.GetIngredient().GetName().equals(i.GetName()))
                    if (j.getLeft() >= i.GetNeeded()) {
                        ret = true;
                    }else ret = false;

        return ret;
    }
    ArrayList<Product> ShowAllowedProduct(ArrayList<Stock> stocks, ArrayList<Product> products) {
        ArrayList<Product> returnproduct = new ArrayList<>();
        for (Product product : products) {
            if (ProductAvailable(stocks,product))
                returnproduct.add(product);
        }
        return returnproduct;
        //System.out.println(sb.toString());
        //for (Product product : j) {
        /*
            ArrayList<Ingredient> productIngredient = product.GetIngredients();
            for (int a = 0; a < productIngredient.size(); a++) {
                if (i.size() <= a) {
                    int index = productIngredient.indexOf(i.get(a).GetIngredient());
                    if (index != -1)
                        if (productIngredient.get(index))
                }
            }
            for (Ingredient ingredient : productIngredient) {
                System.out.println(i.indexOf(ingredient));
                //ingredient.
            }
         */
    }
}
