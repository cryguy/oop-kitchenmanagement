package com.shy;

/*
TODO Return Price, Loop to find Price, After paid call Order Management and delete order
 */
class Cashier {
    // --Commented out by Inspection START (11/5/2018 8:28 AM):
    public static void showOrders() {
        for (Order i : OrderManagement.getInstance().ShowOrders()) {
            System.out.println(i.showOrder());
        }
    }
// --Commented out by Inspection STOP (11/5/2018 8:28 AM)
static void showOrder(Order i) {
        System.out.println(i.showOrder());
        System.out.println("Total Price : " + getPrice(i));
    }

    static private double getPrice(Order i) {
        return i.getPrice();
    }

}
