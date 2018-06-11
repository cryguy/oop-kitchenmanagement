package com.shy;
import com.github.signaflo.timeseries.TimePeriod;
import com.github.signaflo.timeseries.TimeSeries;
import com.github.signaflo.timeseries.Ts;
import com.github.signaflo.timeseries.forecast.Forecast;
import com.github.signaflo.timeseries.model.arima.Arima;
import com.github.signaflo.timeseries.model.arima.ArimaOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Prediction {


    /**
     * declare variable of prediction
     */
    // TODO: 20/May/2018 Maybe add function to see if forecasted result is accurate and print accuracy %

    private final ArimaOrder modelOrder = ArimaOrder.order(0, 1, 1, 0, 1, 1);
    private ArrayList<String> TimeSeriesArrayName = new ArrayList<>();
    private ArrayList<TimeSeries> TimeSeries = new ArrayList<>();
    //private Map<String, TimeSeries> TimeSeriesMap = new HashMap<>();
    private ArrayList<String> forecastArrayName = new ArrayList<>();
    private ArrayList<Forecast> forecast = new ArrayList<>();
    //private Map<String, Forecast> forecastMap = new HashMap<>();

    private static Prediction instance = null;

    private Prediction() {
    }

    /**
     *Prevents us from making more than 1 instance and causing problems
     */

    synchronized static Prediction getInstance() {
        if (instance == null) {
            instance = new Prediction();
        }
        return instance;
    }

    void addData(String name, double[] data) {
        TimeSeriesArrayName.add(name);
        TimeSeries.add(Ts.newWeeklySeries(data));
    }

    void resetData() {
        TimeSeriesArrayName.clear();
        TimeSeries.clear();
    }


    void runPrediction() {
        forecastArrayName.clear();
        forecast.clear(); // clear existing data
        for (int counter=0;counter < TimeSeriesArrayName.size(); counter++)
        {
            forecastArrayName.add(TimeSeriesArrayName.get(counter));
            forecast.add(Arima.model(TimeSeries.get(counter), modelOrder, TimePeriod.halfMonth()).forecast(1));
        }
        resetData();
    }


    /**
     *print out the prediction of the ingredient that need to prepare
     */
    // TODO: 20/May/2018 Change the way its printed to accomodate multiple days of prediction
    void printPredictions() {
        runPrediction();
        System.out.println("---------- Prediction ----------");
        System.out.println("Name       Prediction LOW-UP-MID");
        for (int counter=0;counter < forecastArrayName.size(); counter++)
        {
            System.out.printf("%-11s", forecastArrayName.get(counter));
            System.out.printf("%10.0f  %2.0f %2.0f  %2.0f\n",
                    forecast.get(counter).pointEstimates().at(0),
                    forecast.get(counter).lowerPredictionInterval().at(0),
                    forecast.get(counter).upperPredictionInterval().at(0),
                    forecast.get(counter).pointEstimates().at(0));
        }
    }

    boolean forecastContainsName (String name){
        for (String forecastName : forecastArrayName) {
            if (forecastName.equals(name))
                return true;
        }
        return false;
    }
    Forecast getForecast(String name){
        int counter;
        for (counter=0;counter < forecastArrayName.size(); counter++)
        {
            if (forecastArrayName.get(counter).equals(name))
                break;
        }
        return forecast.get(counter);
    }
    int[] getPrediction(String name) {
        int[] a = new int[3];
        if (forecastContainsName(name)) // check if it exists in the map, if not we will crash
        {
            a[0] = (int) getForecast(name).pointEstimates().at(0);
            a[1] = (int) getForecast(name).lowerPredictionInterval().at(0);
            a[2] = (int) getForecast(name).upperPredictionInterval().at(0);
        }
        return a;
    }

/*
    static void test(){
        TimeSeries series = Ts.newWeeklySeries(18.0,12.0,15.0,5); // input data here
        ArimaOrder modelOrder = ArimaOrder.order(0, 1, 1, 0, 1, 1);
        Arima model = Arima.model(series, modelOrder,TimePeriod.halfMonth()); // half month is juz to allow lower input
        Forecast forecast = model.forecast(1); // days to look ahead
        System.out.println(forecast.pointEstimates().at(0)); // prints out forecast
        System.out.println(forecast.lowerPredictionInterval().at(0));
        System.out.println(forecast.upperPredictionInterval().at(0));
        /*
            | Date              | Forecast     | Lower 95.0%  | Upper 95.0% |
             --------------------------------------------------------------
            | 0001-01-29T00:00  | 7.999710941  | 0.159855042  | 15.83956684 |
         */
    //}

}
