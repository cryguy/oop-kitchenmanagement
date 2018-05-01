package com.shy;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        ADD MAIN MENU
         */

        //MAIN MENU


        /*
        ADD FUNCTIONS TO DO AND RETURN TO MAIN MENU
         */




        // DEMO OF Ingredient Class
        Ingredient a = new Ingredient("spaghetti",500);
        Ingredient b = new Ingredient("onion",500);
        Ingredient c = new Ingredient("water",500);
        // test
        ArrayList<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock(a.GetName(), 50));
        stocks.add(new Stock(b.GetName(), 50));
        stocks.add(new Stock(c.GetName(), 50));

        ArrayList<Ingredient> listofing = new ArrayList<>();
        listofing.add(a);
        listofing.add(b);
        listofing.add(c);


        // DEMO of Product Class
        Product sushi = new Product("sushi",1,50, 5 , listofing);
        ArrayList<Ingredient> produ = sushi.GetIngredients();
        System.out.println(sushi.GetName() + " " + sushi.GetPrice());
        for(Ingredient i : produ)
            System.out.println(i.GetName() + " " + i.GetPrice());
        for(Stock i : stocks)
            System.out.println(i.GetName() + " " + i.getLeft());
    }



    private void menu() {
        //SHOW MENU -- ADD OPTIONS
    }
}
