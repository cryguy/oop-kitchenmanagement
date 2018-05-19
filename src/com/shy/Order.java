package com.shy;

import java.util.ArrayList;

class Order {

    /**
     * Identifier of order
     */
    final private int identifier;

    /**
     * ArrayList of Products in order
     */
    private final ArrayList<Product> orderList = new ArrayList<>();

    /**
     * Creates a new order with the given identifier
     */
    Order(int i) {this.identifier=i;}

    /**
     * Gets identifier of order
     *
     * @return name/identifier of order
     */
    int getName() {
        return this.identifier;
    }

    /**
     * @param i Product to check
     * @return true if the product is already in the Array
     */
    private boolean ContainProduct(Product i) {
        if (!this.orderList.isEmpty()) {
            for (int x = 0; x <= this.orderList.size() - 1; x++) {
                if (this.orderList.get(x).getName().equals(i.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Add Product into array of products
     * @param i the product to add
     */
    void AddProduct(Product i) {
        if (ContainProduct(i)) { // was using orderList.size() just now, and it did'nt work cos a'lot of extra work :P
            for (int x = 0; x <= this.orderList.size() - 1; x++) {
                if (this.orderList.get(x).getName().equals(i.getName())) {
                    this.orderList.get(x).addQuantity(i.getQuantity());
                }
            }
        } else
            this.orderList.add(i);
        StockManagement.getInstance().ReduceQuantity(i);
    }

    /**
     * get price of all product in order and add them together
     *
     * @return price of Order
     */
    //void RemoveProduct
    double getPrice() {
        double price = 0;
        for (Product i : this.orderList) {
            price += i.getPrice()*i.getQuantity();
        }
        return price;
    }

    private void RemoveEmptyProduct() {
        this.orderList.removeIf((Product product) -> {
            boolean ret = product.getQuantity() <= 0;
            if (ret)
                System.out.println("Deleting Product - " + product.getName() + " from order because quantity " +
                        "is less than or equal to 0"); // added this for the logging , can be removed and used as a 1 liner
            return ret;

        });
    }
    /**
     * Gets all product in order and generate String
     *
     * @return String containing all order and price of product
     */
    // TODO : Might want to change String to Array? Not sure bout this, maybe void and then just Println all the orders
    String showOrder() {
        RemoveEmptyProduct();
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (Product i : this.orderList) {
            ++counter;
            sb.append(counter).append(". ").append(i.getName()).append(" ").append(i.getQuantity()).append(" ").
                    append(i.getPrice() * i.getQuantity()).append("\n");
        }
        return sb.toString();
    }


    /**
     * Gets ArrayList of Product in order.
     *
     * @return orderList
     */
    ArrayList<Product> GetOrderProduct() {
        return this.orderList;
    }

// --Commented out by Inspection START (11/5/2018 8:34 AM):
//    /**
//     * Delete Product i from orderList
//     * @param i Product to delete
//     */
//    void deleteProduct(Product i) {
//        this.orderList.get(this.orderList.indexOf(i)).setQuantity(0);
//        RemoveEmptyProduct();
//    }
// --Commented out by Inspection STOP (11/5/2018 8:34 AM)
}
