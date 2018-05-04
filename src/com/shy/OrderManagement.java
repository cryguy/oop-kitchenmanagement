package com.shy;

import java.util.ArrayList;

class OrderManagement {
        private ArrayList<Order> orders = new ArrayList<>();
        private static OrderManagement instance = null;
        private int counter = 1;
        protected OrderManagement () {}
        /*
        TODO: Save order, delete order, show price, select order
         */
        public synchronized static OrderManagement getInstance() {
            if(instance == null) {
                instance = new OrderManagement();
            }
            return instance;
        }
        Order NewOrder () {
            Order i = new Order(counter++);
            orders.add(i);
            return i;
            // counter works better than size, because we will
            // need to check for a lot of other stuff if we use size()+1
        }
        Order GetOrder (int i) {
            for (int x = 0; x <= this.orders.size(); x++) {
                if (this.orders.get(x).getName() == i) {
                    return this.orders.get(x);
                }
            }
            return NewOrder(); // wont ever happen but who knows...
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
