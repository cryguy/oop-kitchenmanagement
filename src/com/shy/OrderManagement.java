package com.shy;

import java.util.ArrayList;

class OrderManagement {
        private ArrayList<Order> orders = new ArrayList<>();
        private int counter = 1;
        /*
        TODO: Save order, delete order, show price, select order,
         */
        OrderManagement() {}

        Order NewOrder () {
            Order i = new Order(Integer.toString(counter++));
            orders.add(i);
            return i;
            // counter works better than size, because we will
            // need to check for a lot of other stuff if we use size()+1
        }
        Order GetOrder (String i) {
            for (int x = 0; x <= this.orders.size(); x++) {
                if (this.orders.get(x).getName().equals(i)) {
                    return this.orders.get(x);
                }
            }
            return new Order("NULL");
        }
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
