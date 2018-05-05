package com.shy;

import java.util.ArrayList;
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

    public void showOrder(Order i) {
        i.showOrder();
        System.out.println("Total Price : " + getPrice(i));
    }

    private double getPrice(Order i) {
        return i.getPrice();
    }

}
