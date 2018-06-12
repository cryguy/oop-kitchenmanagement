
package com.shy;

public class Main {
    public static void main(String[] args) {
        String json = "{\"productJson\":\"[{\\\"name\\\":\\\"AAA\\\",\\\"price\\\":40.0,\\\"quantity\\\":1,\\\"ingredients\\\":[{\\\"name\\\":\\\"Abb\\\",\\\"price\\\":5.0,\\\"needed\\\":2}]}]\",\"stockJson\":\"{\\\"stocks\\\":[{\\\"left\\\":94,\\\"name\\\":\\\"Abb\\\",\\\"price\\\":5.0,\\\"needed\\\":0}],\\\"daycounter\\\":{\\\"Abb\\\":1},\\\"stockuse\\\":{\\\"Abb\\\":[6.0]}}\",\"orderJson\":\"[{\\\"identifier\\\":1,\\\"orderList\\\":[{\\\"name\\\":\\\"AAA\\\",\\\"price\\\":40.0,\\\"quantity\\\":3,\\\"ingredients\\\":[{\\\"name\\\":\\\"Abb\\\",\\\"price\\\":5.0,\\\"needed\\\":2}]}]}]\"}";
        Json.fromString(json).restoreAll();
        Menu menu = new Menu();
        menu.mainMenu();
    }
}
