package com.shy;

import java.util.ArrayList;

class Stock {
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
}