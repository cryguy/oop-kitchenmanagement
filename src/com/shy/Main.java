
package com.shy;

public class Main {


    public static void main(String[] args) {
        String json = "{\"productJson\":\"[{\\\"name\\\":\\\"AcidA\\\",\\\"price\\\":50.0,\\\"quantity\\\":1,\\\"ingredients\\\":[{\\\"name\\\":\\\"waterA\\\",\\\"price\\\":1.0,\\\"needed\\\":5}]},{\\\"name\\\":\\\"AcidB\\\",\\\"price\\\":100.0,\\\"quantity\\\":1,\\\"ingredients\\\":[{\\\"name\\\":\\\"waterB\\\",\\\"price\\\":1.0,\\\"needed\\\":5},{\\\"name\\\":\\\"waterA\\\",\\\"price\\\":1.0,\\\"needed\\\":10}]}]\",\"stockJson\":\"[{\\\"left\\\":40,\\\"name\\\":\\\"waterA\\\",\\\"price\\\":1.0,\\\"needed\\\":0},{\\\"left\\\":45,\\\"name\\\":\\\"waterB\\\",\\\"price\\\":1.0,\\\"needed\\\":0}]\",\"orderJson\":\"[{\\\"identifier\\\":1,\\\"orderList\\\":[{\\\"name\\\":\\\"AcidB\\\",\\\"price\\\":100.0,\\\"quantity\\\":1,\\\"ingredients\\\":[{\\\"name\\\":\\\"waterB\\\",\\\"price\\\":1.0,\\\"needed\\\":5},{\\\"name\\\":\\\"waterA\\\",\\\"price\\\":1.0,\\\"needed\\\":10}]}]}]\"}";
        Json.fromString(json).restoreAll();
        Menu menu = new Menu();
        menu.mainMenu();
    }
}
