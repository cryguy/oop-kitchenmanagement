
package com.shy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // todo : ADD method to make Stock, Add to ArrayList<STOCK>
        // todo : ADD method to make product, and then select ingredient from Stock <3
        // todo : ADD menu to see order
        // todo : ADD menu and function to add quantity to order, and making a separate function to
        // todo : check if the amount is available before adding to cart
        // todo : ADD functions to support w/e thats needed


        Ingredient a = new Ingredient("Spaghetti",50);
        Ingredient b = new Ingredient("Onion",25);
        Ingredient c = new Ingredient("Water",50);
        //stocks.add(new Stock(a, 50));
        //stocks.add(new Stock(b, 5));
        //stocks.add(new Stock(c, 50));
        ArrayList<Ingredient> listofing = new ArrayList<>();
        listofing.add(a);
        listofing.add(b);
        listofing.add(c);

        // DEMO of Product Class
        Product sushi = new Product("sushi", 50, listofing);
        //products.add(sushi);
        Menu menu = new Menu();
        menu.mainmenu();
        //System.out.println(order.showOrder());
    }






}


