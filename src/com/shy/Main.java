package com.shy;

import java.util.ArrayList;

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
        Ingredient a = new Ingredient("a",50);
        Ingredient b = new Ingredient("b",50);
        Ingredient c = new Ingredient("c",50);
        // test
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

    }



    private void menu() {
        //SHOW MENU -- ADD OPTIONS
    }
}
