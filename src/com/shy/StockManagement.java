package com.shy;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class StockManagement {
    // StockManagement is an object that contains the array of Stocks
    ArrayList<Stock> stocks = new ArrayList<>();
    private Map<String, Integer> stockuse = new HashMap<>();
    private static StockManagement instance = null;

    private StockManagement() {
    }
    /*
    Prevents us from making more than 1 instance and causing problems
    -- SINGLETON
     */


    synchronized static StockManagement getInstance() {
        if(instance == null) {
            instance = new StockManagement();
        }
        return instance;
    }

    boolean IsEmpty() {
        return stocks.isEmpty();
    }

    void AddStock(String name, double price, int left) {
        stocks.add(new Stock(name, price, left));
    }
    void PrintStocks(){
        int x = 0;
        for (Stock i : stocks)
        {
            System.out.printf("%d\t %s\t\t%d%n", ++x, i.getName(), i.getLeft());
            //System.out.println(++x + ". " + i.GetName() + " " + i.getLeft());
        }
    }
    void ReduceQuantity(Product product) {
        for (Ingredient i : product.getIngredients())
            for (Stock j : stocks)
                if (j.GetName().equals(i.GetName())) {
                    addToList(i.GetName(), i.GetNeeded() * product.getQuantity());
                    j.reduceLeft(i.GetNeeded() * product.getQuantity());
                    break;
                }
    }

    private void addToList(String name, int numtoadd) {
        stockuse.put(name, stockuse.getOrDefault(name, 0) + numtoadd);
    }

    void printPairsDebug() {
        for (Map.Entry<String, Integer> entry : stockuse.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    void setStocks(String json) {
        stocks = Json.a.fromJson(json, new TypeToken<ArrayList<Stock>>() {
        }.getType());
    }

    String toJson() {
        return Json.a.toJson(stocks);
    }
    void DeleteStock(Stock i) {
        stocks.remove(i);
    }

    ArrayList<Stock> getStock() {
        return stocks;
    }


}

