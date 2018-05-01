package com.shy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //denish was here
        //main menu i guess
        int main_menu_op=0;

        System.out.print("Main Menu\n\n 1. Order\n 2. Product Management\n 3. Inventory Management\n\nChoose your option: ");
        Scanner mmo = new Scanner(System.in);
        main_menu_op = mmo.nextInt();
        switch(main_menu_op){
            case 1:
                System.out.printf("1");
                //should display products from products class and need to create another switch here
                //order
                break;
            case 2:
                System.out.printf("2");
                //product_management
                break;
            case 3:
                System.out.printf("3");
                //inventory_management
                break;
             default:
                 System.out.printf("not foun");
                 //dead
                break;
        }
        Ingredient a = new Ingredient("Spaghetti",50);
        Ingredient b = new Ingredient("Onion",50);
        Ingredient c = new Ingredient("Water",50);
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
