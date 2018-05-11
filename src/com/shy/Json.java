package com.shy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Json {
    final static Gson a = new Gson();
    private final String productJson;
    private final String stockJson;
    private final String orderJson;

    private Json() {
        this.productJson = ProductManagement.getInstance().toJson();
        this.orderJson = OrderManagement.getInstance().toJson();
        this.stockJson = StockManagement.getInstance().toJson();
    }

    public static Json fromString(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Json.class);
    }

    public static void printString() {
        System.out.println(new Gson().toJson(new Json()));
    }

    public static void prettyPrint() {
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(new Json()));
    }

    void restoreAll() {
        ProductManagement.getInstance().setProducts(this.productJson);
        StockManagement.getInstance().setStocks(this.stockJson);
        OrderManagement.getInstance().setOrders(this.orderJson);
    }

}
