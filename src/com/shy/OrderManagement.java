package com.shy;

import java.util.ArrayList;

class OrderManagement {
        private ArrayList<Order> orders = new ArrayList<>();
        /*
        TODO: Save order, delete order, show price, select order,
         */
        OrderManagement() {}

        void SaveOrder (Order i){
            orders.add(i);
        }

        void DeleteOrder (Order i){
            orders.remove(i);
        }

        ArrayList<Order> ShowOrders (){
            return this.orders;
        }
}
