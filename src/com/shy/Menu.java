package com.shy;

import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    private static ArrayList<Stock> stocks = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner mmo = new Scanner(System.in);
    private static OrderManagement orderManagement = new OrderManagement();
    Menu () {}
    private void clear() {
        System.out.print("\033[H\033[2J");
    }

    void mainmenu() {
        //SHOW MENU -- ADD OPTIONS
        int main_menu_op;

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
        Order order = orderManagement.NewOrder();
        ArrayList<Product> productList = order.showAllowedProduct(stocks,products);
        if (productList.isEmpty()) {
            System.out.println("ERROR - ALL PRODUCTS OUT OF STOCK!");
            return;
        }
        int x = 0;
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
