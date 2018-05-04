package com.shy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    private static ArrayList<Stock> stocks = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner mmo = new Scanner(System.in);
    Menu () {}
    private void clear()
    {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows"))
        {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // clear cmd by running cmd /c cls
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            try {
                Runtime.getRuntime().exec("clear");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void mainmenu() {
        int main_menu_op;
        clear();
        System.out.print("Main Menu\n\n 1. Order\n 2. Orders Management\n 3. Product Management\n 4. Inventory Management\n\nChoose your option: ");

        main_menu_op = mmo.nextInt();
        switch(main_menu_op){
            case 1:
                //once user choose this option the ordermenu() will come up
                ordermenu();
                break;
            case 2:
                System.out.print("2\n");
                //product_management
                break;
            case 3:
                System.out.print("3\n");
                //inventory_management
                break;
            case 4:

            default:
                System.out.print("not found\n");
                //dead
                break;
        }
    }
    // this would be the order menu
    private void ordermenu(){
        clear();
        System.out.println(OrderManagement.getInstance().GetOrder(1).showOrder());
        int count = 1;
        for (Stock i :StockManagement.stocks)
            System.out.println(count++ + " " +i.getIngredient().GetName() + " - " + i.getLeft());
        // testing ^
        int selection = -1;
        do {
            Order order = OrderManagement.getInstance().NewOrder();
            ArrayList<Product> productList = order.showAllowedProduct(stocks,products);
            if (productList.isEmpty()) {
                System.out.println("ERROR - ALL PRODUCTS OUT OF STOCK!");
                return;
            }
            int x = 0;
            for (Product i : productList) {
                System.out.println(++x + ": " + i.getName());
            }
            System.out.println("0 : Show Ordered & Confirm Order");
            selection = mmo.nextInt();
            if (selection-1 <= productList.size() && selection != 0 && selection >= 1) {
                order.AddProduct(productList.get(selection-1));
            } else if (selection == 0) {
                System.out.println(order.showOrder());
            } else {
                System.out.println("Error Please Select Again.");
            }
        } while (selection != 0);




    }
}
