package com.shy;

import com.sun.corba.se.spi.orbutil.fsm.Input;

/*
TODO Return Price, Loop to find Price, After paid call Order Management and delete order
 */
class Cashier {
    private static double cash;

    /**
     * Getting the thing store in order array list and print out the details
     */

    public static void payForOrder(Order i){
        showOrder(i);
        double paid = Menu.getInput("Enter Money Paid", new input.DoubleInputGrabber());
        System.out.println("Change is : RM" + (paid-getPrice(i)));
        cash += getPrice(i);
    }

    static void showOrders() {
        for (Order i : OrderManagement.getInstance().ShowOrders()) {
            System.out.println(i.showOrder());

        }
    }

    /**
     * print out the details of order and get the price of the order
     */
    private static void showOrder(Order i) { //show the order and the price
        System.out.println(i.showOrder());
        System.out.println("Total Price : " + getPrice(i));
    }

    /**
     * get price of the order
     *
     * @return price of order
     */

    static private double getPrice(Order i) {
        return i.getPrice();
    }
}

