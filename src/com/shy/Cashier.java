package com.shy;

/*
TODO Return Price, Loop to find Price, After paid call Order Management and delete order
 */
class Cashier {
    // --Commented out by Inspection START (11/5/2018 8:28 AM):

    /**
     * Getting the thing store in order array list and print out the details
     */

    public static void showOrders() {
        for (Order i : OrderManagement.getInstance().ShowOrders()) {
            System.out.println(i.showOrder());

        }
    }


    // --Commented out by Inspection STOP (11/5/2018 8:28 AM)

    /**
     * print out the details of order and get the price of the order
     */
    static void showOrder(Order i) { //show the order and the price
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

