
package com.shy;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        // todo : ADD method to make Stock, Add to ArrayList<STOCK>
        // todo : ADD method to make product, and then select ingredient from Stock <3
        // todo : ADD menu to see order
        // todo : ADD menu and function to add quantity to order, and making a separate function to
        // todo : check if the amount is available before adding to cart
        // todo : ADD functions to support w/e thats needed
        OrderManagement orderManagement = OrderManagement.getInstance();
        Order order = orderManagement.NewOrder();
        Ingredient a = new Ingredient("Spaghetti",50);
        Ingredient b = new Ingredient("Onion",25);
        Ingredient c = new Ingredient("Water",50);
        StockManagement stockManagement = StockManagement.getInstance();
        StockManagement.stocks.add(new Stock("Spaghetti", 15.00, 1000));
        StockManagement.stocks.add(new Stock("Onion", 15.00, 1000));
        StockManagement.stocks.add(new Stock("Water", 15.00, 1000));

        ArrayList<Ingredient> listofing = new ArrayList<>();
        listofing.add(a);
        listofing.add(b);
        listofing.add(c);
        int count =1;
        // DEMO of Product Class
        ProductManagement.products.add(new Product("sushi", 50, listofing));
        ProductManagement.products.add(new Product("Test", 10, listofing));
        Menu menu = new Menu();
        menu.mainmenu();

    }
}
