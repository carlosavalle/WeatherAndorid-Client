package com.example.weatherapp;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;

public class Forecast extends Thread{
    private String CityName;
    private MainActivity activity;

    public Forecast(String cityName, MainActivity activity) {
        CityName = cityName;
        this.activity = activity;
    }


    @Override
    public void run() {
        getForecast();
    }

    private void getForecast() {

        Gson gson = new Gson();
        Log.d("Forecast","it is getting the Forecast for that city on a background thread");

        ArrayList<WeatherForecastSummary> wfs_list = new ArrayList();
        String result = ReadJSON.readHTTP("https://api.openweathermap.org/data/2.5/forecast?q=" + this.CityName + "&units=imperial&apiKey=6ae2281a443225f45f30cc3a4a1d37b2");
        WeatherForecast wf1 = (WeatherForecast)gson.fromJson(result, WeatherForecast.class);
        Iterator var16 = wf1.getList().iterator();

        while(var16.hasNext()) {
            WeatherForecastItem wf2 = (WeatherForecastItem)var16.next();
            WeatherForecastSummary auxWFS = new WeatherForecastSummary(wf2.getTime(),wf2.getMaxTemp(),wf2.getWind().getSpeed(),wf2.getWeatherCondition());
            wfs_list.add(auxWFS);
        }




        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
            activity.displayForecast(wfs_list);
            }
        });

    }
}
