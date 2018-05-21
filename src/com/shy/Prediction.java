package com.shy;

import com.github.signaflo.timeseries.TimePeriod;
import com.github.signaflo.timeseries.TimeSeries;
import com.github.signaflo.timeseries.Ts;
import com.github.signaflo.timeseries.forecast.Forecast;
import com.github.signaflo.timeseries.model.arima.Arima;
import com.github.signaflo.timeseries.model.arima.ArimaOrder;

import java.util.HashMap;
import java.util.Map;

class Prediction {
    // TODO: 20/May/2018 Maybe add function to see if forecasted result is accurate and print accuracy %

    private final ArimaOrder modelOrder = ArimaOrder.order(0, 1, 1, 0, 1, 1);
    private Map<String, TimeSeries> TimeSeriesMap = new HashMap<>();
    private Map<String, Forecast> forecastMap = new HashMap<>();

    private static Prediction instance = null;

    private Prediction() {
    }

    /*
    Prevents us from making more than 1 instance and causing problems
    -- SINGLETON
     */
    synchronized static Prediction getInstance() {
        if (instance == null) {
            instance = new Prediction();
        }
        return instance;
    }

    void addData(String name, double[] data) {
        TimeSeriesMap.put(name, Ts.newWeeklySeries(data));
    }

    // call resetData in the Inventory loop
    void resetData() {
        TimeSeriesMap.clear();
    }

    void runPrediction() {
        forecastMap.clear(); // clear existing data
        for (Map.Entry<String, TimeSeries> entry : TimeSeriesMap.entrySet()) {
            forecastMap.put(entry.getKey(), Arima.model(entry.getValue(), modelOrder, TimePeriod.halfMonth()).forecast(1));
        }
    }

    // TODO: 20/May/2018 Change the way its printed to accomodate multiple days of prediction
    void printPredictions() {
        runPrediction();
        System.out.println("---------- Prediction ----------");
        System.out.println("Name       Prediction LOW-UP-MID");
        for (Map.Entry<String, Forecast> entry : forecastMap.entrySet()) {
            System.out.printf("%-11s", entry.getKey());
            System.out.printf("%10.0f  %2.0f %2.0f  %2.0f\n",
                    entry.getValue().pointEstimates().at(0),
                    entry.getValue().lowerPredictionInterval().at(0),
                    entry.getValue().upperPredictionInterval().at(0),
                    entry.getValue().pointEstimates().at(0));
        }
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
