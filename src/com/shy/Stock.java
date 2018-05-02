package com.shy;

class Stock {
    /*

    todo : add method to change value of left
    todo : add method to loop thru array to get what we need easily
    todo : add bool method to check if item is available - dunno if we should do it here or in product

    */
    private int left;
    private Ingredient ingredient;
    Stock(Ingredient ingredient, int left){
        this.left = left;
        this.ingredient = ingredient;
    }
    int getLeft() {
        return this.left;
    }
    Ingredient getIngredient() {
        return this.ingredient;
    }
    void reduceLeft(int reduce) {
        this.left -= reduce;
    }
    void addLeft(int add) { this.left += add; }
}