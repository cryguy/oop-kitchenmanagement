package com.shy;

/*
TODO Return Price, Loop to find Price, After paid call Order Management and delete order
 */
public class Cashier{
    public void showOrders(){
        for (Order i : OrderManagement.getInstance().ShowOrders())
        {
            i.showOrder();
        }
    }

    //test 1
    void showOrder(Order i) {
        System.out.println(i.showOrder());
        System.out.println("Total Price : " + getPrice(i));
    }

    private double getPrice(Order i) {
        return i.getPrice();
    }

}
