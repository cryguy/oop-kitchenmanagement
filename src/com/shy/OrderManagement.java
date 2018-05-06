package com.shy;

import java.util.ArrayList;
import java.util.ListIterator;

class OrderManagement {
        private ArrayList<Order> orders = new ArrayList<>();
        private static OrderManagement instance = null;
        private int counter = 1;

    private OrderManagement() {
    }

    synchronized static OrderManagement getInstance() {
        if (instance == null) {
            instance = new OrderManagement();
        }
        return instance;
    }

    void CheckEmptyOrderAndRemove() {
        ListIterator<Order> iter = orders.listIterator();
        orders.removeIf((Order order) -> {
            boolean ret = order.GetOrderProduct().isEmpty();
            if (ret)
                System.out.println("Deleting Order - " + order.getName() + "   which is empty"); // added this for the logging , can be removed and used as a 1 liner
            return ret;

        });
        // orders.removeIf((Order order) -> order.GetOrderProduct().isEmpty());
    }
            /*

            the one on top is basically this but using a lambda function which is a function which is anonymous
            the function only exists for that function call, and its alot faster than the way below, efficiency is
            time complexity is O(n) vs O(n2) which is the code below


            while (iter.hasNext())
            if (iter.next().GetOrderProduct().isEmpty()) {
                System.out.println("Deleting Order - " + iter.next().getName() + "   which is empty");
                iter.remove();
            }
            */

    Order NewOrder() {
        Order i = new Order(counter++);
        orders.add(i);
        return i;
        // counter works better than size, because we will
        // need to check for a lot of other stuff if we use size()+1
    }

    Order GetOrder(int i) {
        for (int x = 0; x <= this.orders.size(); x++) {
            if (this.orders.get(x).getName() == i) {
                return this.orders.get(x);
            }
        }
        return NewOrder(); // wont ever happen but who knows...
    }

    void SaveOrder(Order i) {
        orders.add(i);
    }

    void DeleteOrder(Order i) {
        orders.remove(i);
    }

    ArrayList<Order> ShowOrders() {
        return this.orders;
    }
}
