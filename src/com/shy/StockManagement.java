package com.shy;
import com.google.gson.reflect.TypeToken;

import java.util.*;


/**
 * declare the variable of stockmanagement
 */
class StockManagement {
    // StockManagement is an object that contains the array of Stocks
    ArrayList<Stock> stocks = new ArrayList<>();
    private ArrayList<String> nameReferenceForDay = new ArrayList<>();
    private ArrayList<Integer> dayCounter = new ArrayList<>();
    //private Map<String, Integer> daycounter = new HashMap<>();
    private ArrayList<String> stockReference = new ArrayList<>();
    private ArrayList<ArrayList<Double>> stockUse = new ArrayList<>();
    //private Map<String, ArrayList<Double>> stockuse = new HashMap<>();
    private static StockManagement instance = null;

    private StockManagement() {
    }

    /**
     *make sure that will only one person can be access into the stock management at the same time
     */

    synchronized static StockManagement getInstance() {
        if(instance == null) {
            instance = new StockManagement();
        }
        return instance;
    }


    /**
     *to check whether the stock is it empty
     * @return value of stocks
     */

    boolean IsEmpty() {
        return stocks.isEmpty();
    }


    /**
     *for adding new stock and store them into the stocks with details
     */

    void AddStock(String name, double price, int left) {
        stocks.add(new Stock(name, price, left));
    }


    /**
     *get the stocks details
     */

    void PrintStocks(){
        int x = 0;
        for (Stock i : stocks) {
            System.out.printf("%d\t %s\t\t%d%n", ++x, i.getName(), i.getLeft());
            //System.out.println(++x + ". " + i.GetName() + " " + i.getLeft());
        }
    }


    /**
     *check if the ingredient used have stock and reduce the ingredient in stock
     */
    void ReduceQuantity(Product product) {
        for (Ingredient i : product.getIngredients())
            for (Stock j : stocks)
                if (j.GetName().equals(i.GetName())) {
                    addToList(i.GetName(), i.GetNeeded() * product.getQuantity());
                    j.reduceLeft(i.GetNeeded() * product.getQuantity());
                    break;
                }
    }

    /**
     *add the stock for ingredient quantity
     */

    void addStockQuantity(int index, int numbertoadd) {
        this.getStock().get(index).addLeft(numbertoadd);
    }


    void putIfNotExistsIntoDay(String name){
        boolean exists = false;
        for (String aNameReferenceForDay : nameReferenceForDay) {
            if (aNameReferenceForDay.equals(name)) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            nameReferenceForDay.add(name);
            dayCounter.add(0);
        }
    }
    int getDayFromReference(String name)
    {
        int counter;
        for (counter = 0 ; counter < nameReferenceForDay.size(); counter ++){
            if (nameReferenceForDay.get(counter).equals(name))
                break;
        }
        return dayCounter.get(counter);
    }
    private void incrementDay()
    {
        for (int i = 0; i < dayCounter.size(); i++){
            dayCounter.set(i, dayCounter.get(i)+1);
        }
    }

    /**
     *
     */
    void endDay() {

        incrementDay();

        for (int counter=0;counter < stockReference.size(); counter++)
        {
            if (stockUse.get(counter).size() > 2){
                double[] target = new double[stockUse.get(counter).size()];
                for (int i = 0; i < target.length; i++) {
                    target[i] = stockUse.get(counter).get(i); // to unBox Double to double...
                }
                Prediction.getInstance().addData(stockReference.get(counter), target);
            }
        }
        //Prediction.getInstance().runPrediction();
        Prediction.getInstance().printPredictions();

    }

    boolean stockInReference(String name){
        for (String aStockReference : stockReference) {
            if (aStockReference.equals(name))
                return true;
        }
        return false;
    }

    ArrayList<Double> getArrayFromName (String name){
        int counter;
        for (counter = 0 ; counter < stockReference.size(); counter ++){
            if (stockReference.get(counter).equals(name))
                break;
        }
        return stockUse.get(counter);
    }

    void putInReference(String name, ArrayList<Double> stockused) {
      stockReference.add(name);
      stockUse.add(stockused);
    }
    private void addToList(String name, double numtoadd) {
        putIfNotExistsIntoDay(name);
        if (!stockInReference(name)) {
            ArrayList<Double> arraylist = new ArrayList<>();
            arraylist.add(getDayFromReference(name), numtoadd);
            putInReference(name, arraylist);
        } else {
            ArrayList<Double> arraylist = getArrayFromName(name);
            if (getDayFromReference(name) >= arraylist.size())
                arraylist.add(getDayFromReference(name), numtoadd);
            arraylist.set(getDayFromReference(name), arraylist.get(getDayFromReference(name)) + numtoadd);
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

