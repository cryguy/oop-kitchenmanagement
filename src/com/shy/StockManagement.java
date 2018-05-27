package com.shy;

import com.google.gson.reflect.TypeToken;

import java.util.*;

class StockManagement {
    // StockManagement is an object that contains the array of Stocks
    ArrayList<Stock> stocks = new ArrayList<>();
    private Map<String, Integer> daycounter = new HashMap<>();
    private Map<String, ArrayList<Double>> stockuse = new HashMap<>();
    private static StockManagement instance = null;

    private StockManagement() {
    }

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

    void addStockQuantity(int index, int numbertoadd) {
        this.getStock().get(index).addLeft(numbertoadd);
    }
    void endDay() {
        for (Map.Entry<String, Integer> entry : daycounter.entrySet())
            entry.setValue(entry.getValue() + 1);
        for (Map.Entry<String, ArrayList<Double>> entry : stockuse.entrySet()) {
            if (entry.getValue().size() > 2) {
                double[] target = new double[entry.getValue().size()];
                for (int i = 0; i < target.length; i++) {
                    target[i] = entry.getValue().get(i); // to unBox Double to double...
                }
                //System.out.println(entry.getKey() + " " + Arrays.toString(target));
                //Prediction.getInstance().addData(entry.getKey(), target);
            }
        }
        Prediction.getInstance().runPrediction();
        Prediction.getInstance().printPredictions();

    }

    private void addToList(String name, double numtoadd) {
        daycounter.put(name, daycounter.getOrDefault(name, 0));
        if (!stockuse.containsKey(name)) {
            ArrayList<Double> arraylist = new ArrayList<>();
            arraylist.add(daycounter.get(name), numtoadd);
            stockuse.put(name, arraylist);
        } else {
            ArrayList<Double> arraylist = stockuse.get(name);
            if (daycounter.get(name) >= arraylist.size())
                arraylist.add(daycounter.get(name), numtoadd);
            arraylist.set(daycounter.get(name), arraylist.get(daycounter.get(name)) + numtoadd);
        }
    }

    void printPairsDebug() {
        for (Map.Entry<String, ArrayList<Double>> entry : stockuse.entrySet()) {
            System.out.println(entry.getKey() + " : " + Arrays.toString(entry.getValue().toArray()));
        }
    }
    void setStocks(String json) {
        instance = Json.a.fromJson(json, new TypeToken<StockManagement>() {
        }.getType());
    }

    String toJson() {
        return Json.a.toJson(instance);
    }

    void DeleteStock(Stock i) {
        stocks.remove(i);
    }

    ArrayList<Stock> getStock() {
        return stocks;
    }


}

