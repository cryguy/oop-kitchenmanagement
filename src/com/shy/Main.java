
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
        StockManagement.stocks.add(new Stock(a, 50));
        StockManagement.stocks.add(new Stock(b, 50));
        StockManagement.stocks.add(new Stock(c, 50));

        ArrayList<Ingredient> listofing = new ArrayList<>();
        listofing.add(a);
        listofing.add(b);
        listofing.add(c);
        int count =1;
        for (Stock i :StockManagement.stocks)
            System.out.println(count++ + " " +i.getIngredient().GetName() + " - " + i.getLeft());
        // DEMO of Product Class
        Product sushi = new Product("sushi", 50, listofing);
        order.AddProduct(sushi);
        Menu menu = new Menu();
        menu.mainmenu();

    }
}
