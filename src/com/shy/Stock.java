package com.shy;

class Stock extends Ingredient { // Stock is the child class of ingredient

    /*

    Not sure if we want to use Inheritance here,
    might be better to just use the object because we might need to add this to Product?
    Or we can just make a method to return an Object of Ingredient?

    */

    /**
     * declare variable left
     */
    private int left;


    /**
     *create a overloaded constructor to change the value in field name for store
     */
    Stock(String name, double price, int left) {
        super(name, price);
        this.left = left;
        //this.ingredient = ingredient;
    }


    /**
     *get left of stock
     * @return left
     */
    int getLeft() {
        return this.left;
    }   // Through this method to get left value


    /**
     *get name of ingredient from the parent class
     * @return name of ingredient from parent class
     */
    String getName() {
        return super.GetName();
    }


    /**
     * get price of ingredient
     *
     * @return price of ingredient from parent class
     */
    double getPrice() {
        return super.GetPrice();
    }


    /**
     *get the reduceleft of stock
     * @return to left= left - reduce
     */
    void reduceLeft(int reduce) {
        this.left -= reduce;
    }


    /**
     * get the addleft of stock
     *
     * @return to left = left + add
     */
    void addLeft(int add) {
        this.left += add;
    }

    /**
     *calling the default constructor of ingredient
     */

    Ingredient ingredient() {
        return this;
    }
}