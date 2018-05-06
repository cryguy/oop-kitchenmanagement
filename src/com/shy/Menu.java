package com.shy;

import java.io.IOException;
import java.util.Scanner;


class Menu {
    private static Scanner mmo = new Scanner(System.in);

    Menu() {
    }

    private void clear() {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // clear cmd by running cmd /c cls
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec("clear");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void mainmenu() {
        int main_menu_op;
        while (true) {
            clear();
            OrderManagement.getInstance().CheckEmptyOrderAndRemove();
            System.out.print("Main Menu\n\n 1. Order\n 2. Orders Management\n 3. Product Management\n 4. Inventory Management\n 0. Exit\n\nChoose your option: ");
            main_menu_op = mmo.nextInt();
            switch (main_menu_op) {
                case 1:
                    //once user choose this option the orderMenu() will come up
                    orderMenu();
                    break;
                case 2:
                    System.out.print("2\n");
                    //product_management
                    break;
                case 3:
                    System.out.print("3\n");
                    inventory();
                    break;
                case 4:
                    System.out.println("4\n");
                case 0:
                    return;
                default:
                    System.out.print("not found\n");
                    //dead
                    break;
            }
        }
    }

    // this would be the order menu
    private void orderMenu() {
        ProductManagement.updateAvailable();
        clear();
        StockManagement.getInstance().PrintStocks();
        int selection;
        Order order = OrderManagement.getInstance().NewOrder();
        do {
            if (ProductManagement.availableProducts().isEmpty() && order.GetOrderProduct().size() == 0) {
                System.out.println("ERROR - ALL PRODUCTS OUT OF STOCK!");
                return;
            } else if (ProductManagement.availableProducts().isEmpty() && order.GetOrderProduct().size() != 0)
                break;

            int x = 0;
            for (Product i : ProductManagement.availableProducts()) {
                System.out.println(++x + ": " + i.getName());
            }

            System.out.println("0 : Show Ordered & Confirm Order");
            selection = mmo.nextInt();
            if (selection != 0 && selection >= 1 && (selection - 1) <= ProductManagement.availableProducts().size() - 1) {
                try {
                    order.AddProduct(ProductManagement.availableProducts().get(selection - 1).clone()); // WELL, FIXED IT, Apparently only the Pointer/Reference to object is added
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            } else if (selection != 0 && ((selection - 1) >= (ProductManagement.availableProducts().size() - 1) || selection - 1 < 0)) {
                System.out.println("Error Please Select Again.");
            } else if (selection != 0) System.out.println("Error");

            System.out.println(order.showOrder());
            ProductManagement.updateAvailable();
        } while (selection != 0);

        Cashier a = new Cashier();
        a.showOrder(order);
        StockManagement.getInstance().PrintStocks();

    }

    private void inventory() {
        int main_menu_op;
        while (true) {
            clear();
            System.out.print("Inventory Management\n\n 1. Print Stock\n 2. Add Stock\n 3. Remove Stock\n 0. Exit\n\nChoose your option: ");
            main_menu_op = mmo.nextInt();
            mmo.nextLine();
            switch (main_menu_op) {
                case 1:
                    StockManagement.getInstance().PrintStocks();
                    break;
                case 2:
                    System.out.print("Enter Name of Item : ");
                    String name = mmo.nextLine();
                    double price = getInput("Enter Price of " + name + " : ", new input.DoubleInputGrabber());
                    int left = getInput("Enter Number of " + name + " in stock : ", new input.IntegerInputGrabber());

                    StockManagement.getInstance().AddStock(name, price, left);
                    break;
                case 3:
                    System.out.println("-- Stock List --");
                    if (StockManagement.getInstance().IsEmpty()) {
                        System.out.println("Nothing is in stock !");
                        break;
                    }
                    StockManagement.getInstance().PrintStocks();
                    System.out.println();
                    int selection = getInput("Enter index to delete : ", new input.IntegerInputGrabber());
                    if (selection != 0 && selection >= 1 && (selection - 1) <= StockManagement.stocks.size() - 1) {
                        StockManagement.getInstance().DeleteStock(StockManagement.stocks.get(selection - 1));
                    } else if (selection != 0 && ((selection - 1) >= (StockManagement.stocks.size() - 1) || selection - 1 < 0)) {
                        System.out.println("Error Please Select Again.");
                    } else if (selection != 0) System.out.println("Error");
                    break;
                case 0:
                    return;
            }
        }
    }

    private <T> T getInput(String prompt, input.InputGrabber<T> grabber) {
        System.out.print(prompt);
        do {
            if (grabber.hasNextInput(mmo)) {
                System.out.println(grabber.getExpectedInputFormat());
                System.out.print(prompt);
                mmo.nextLine();
            }
        } while (grabber.hasNextInput(mmo));
        return grabber.getNextInput(mmo);
    }

}