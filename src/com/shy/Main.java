package com.shy;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Ingredient a = new Ingredient("a",50);
        Ingredient b = new Ingredient("b",50);
        Ingredient c = new Ingredient("c",50);
        ArrayList<Ingredient> listofing = new ArrayList<>();
        listofing.add(a);
        listofing.add(b);
        listofing.add(c);
        Product sushi = new Product("sushi",1,50, 5 , listofing);
        ArrayList<Ingredient> produ = sushi.GetIngredients();
        System.out.println(sushi.GetName() + " " + sushi.GetPrice());
        for(Ingredient i : produ)
            System.out.println(i.GetName() + " " + i.GetPrice());
    }
}
