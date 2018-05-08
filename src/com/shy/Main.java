
package com.shy;

public class Main {


    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mainmenu();
    }

    public static int max(int num1, int num2) {
        if (num1 < num2)
            return num1;
        else return num2;
    }
}
