package com.shy;

class Stock {
    /*

    todo : add method to change value of left
    todo : add method to loop thru array to get what we need easily
    todo : add bool method to check if item is available - dunno if we should do it here or in product

    */
    private int left;
    private String name;
    Stock(String name, int left){
        this.left = left;
        this.name = name;
    }
    int getLeft() {
        return this.left;
    }
    String GetName() {
        return this.name;
    }
    void reduceLeft(int reduce) {
        this.left -= reduce;
    }
}