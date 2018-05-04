package com.shy;

import java.util.ArrayList;

/*
    TODO: MIGHT change how Order works, Thinking of making it not use an array of products instead have an array of orders
    TODO: It might simplify the add product and the checks for duplicate and ingredients? Might be more complicated for multiple orders!
 */
class Order {
    private int identifier;
    private ArrayList<Product> orderList = new ArrayList<>();
    private Product product;

    Order(int i) {this.identifier=i;}
    int getName() {
        return this.identifier;
    }
    void AddProduct(Product i) {
        if (!this.orderList.isEmpty()) {
            for (int x = 0; x <= this.orderList.size(); x++) {
                if (this.orderList.get(x).getName().equals(i.getName())) {
                    //done = true;
                    this.orderList.get(x).addQuantity(i.getQuantity());
                    break;
                }
            }
        }
        else
            this.orderList.add(i);
        StockManagement.getInstance().ReduceQuantity(i);
    }

    //void RemoveProduct

    String showOrder() {
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

    void deleteProduct(Product i) {
        orderList.remove(i);
    }

    /*
    TODO order validation looping true each order -product and check if quantity less than 1 and remove the product

     */

    private boolean productAvailable(ArrayList<Stock> stocks, Product product){
        //boolean[] t = new boolean[product.getIngredients().size()];
        //int incre = 0;
        for (Ingredient i : product.getIngredients())
            for (Stock j : stocks)
                if (j.getIngredient().GetName().equals(i.GetName())) {
                    if (!(j.getLeft() >= i.GetNeeded()))
                        return false;
                    break; // break out of 1 for loop as we found it already, don't need to go to the next if we found it
                }
        return true;
    }
    /*
    private static boolean areAllTrue(boolean[] array)
    {
        for(boolean b : array) if(!b) return false;
        return true;
    }
    */
    ArrayList<Product> showAllowedProduct(ArrayList<Stock> stocks, ArrayList<Product> products) {
        ArrayList<Product> returnproduct = new ArrayList<>();
        for (Product product : products) {
            if (productAvailable(stocks,product))
                returnproduct.add(product);
        }
        return returnproduct;
    }
}
