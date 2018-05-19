package com.shy;

import com.github.signaflo.timeseries.TimePeriod;
import com.github.signaflo.timeseries.TimeSeries;
import com.github.signaflo.timeseries.Ts;
import com.github.signaflo.timeseries.forecast.Forecast;
import com.github.signaflo.timeseries.model.arima.Arima;
import com.github.signaflo.timeseries.model.arima.ArimaOrder;

class Prediction {
    Prediction(){}

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
        /*
        TODO: 19/May/2018 Make function to get inventory at end of each day and if data size < 7, input the data into newWeeklySeries
        TODO: 19/May/2018 Make function to print out forecast with upper and lower boundaries and then the expected usage of inventory
        TODO: 19/May/2018 Implement the prediction class in Inventory instead of here
        */
    }

}
