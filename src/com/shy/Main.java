package com.shy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner mmo = new Scanner(System.in);
    private static Order order = new Order();
    private static ArrayList<Stock> stocks = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();

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
        stocks.add(new Stock(a, 50));
        stocks.add(new Stock(b, 5));
        stocks.add(new Stock(c, 50));
        ArrayList<Ingredient> listofing = new ArrayList<>();
        listofing.add(a);
        listofing.add(b);
        listofing.add(c);

        // DEMO of Product Class
        Product sushi = new Product("sushi", 50, listofing);
        products.add(sushi);

        mainmenu();
        //System.out.println(order.showOrder());
    }



    private static void mainmenu() {
        //SHOW MENU -- ADD OPTIONS
        int main_menu_op;

        System.out.print("Main Menu\n\n 1. Order\n 2. Product Management\n 3. Inventory Management\n\nChoose your option: ");

        main_menu_op = mmo.nextInt();
        switch(main_menu_op){
            case 1:
                //once user choose this option the ordermenu() will come up
                ordermenu();
                break;
            case 2:
                System.out.printf("2\n");
                //product_management
                break;
            case 3:
                System.out.printf("3\n");
                //inventory_management
                break;
            default:
                System.out.printf("not found\n");
                //dead
                break;
        }
    }
    // this would be the order menu
    private static void ordermenu(){
        int x = 0;
        ArrayList<Product> productList = order.showAllowedProduct(stocks,products);
        if (productList.isEmpty()) {
            System.out.println("ERROR - ALL PRODUCTS OUT OF STOCK!");
            return;
        }
        for (Product i : productList) {
            x++;
            System.out.println(x + ": " + i.getName());
        }
        int selection = mmo.nextInt();
        if (selection-1 <= productList.size())
            order.AddProduct(productList.get(selection-1));
        else System.out.println("Error Please Select Again.");
        System.out.println(order.showOrder());
    }
}
