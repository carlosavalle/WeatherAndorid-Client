package com.example.weatherapp;
import android.util.Log;

import com.google.gson.Gson;

public class Temperature extends Thread {
    private String CityName;
    private MainActivity activity;

    public Temperature(String cityName, MainActivity activity) {
        CityName = cityName;
        this.activity = activity;
    }
    public void getTemperature(){

        Gson gson = new Gson();
        Log.d("Temperature","it is getting the temperature for that city on a background thread");
        String result = ReadJSON.readHTTP("https://api.openweathermap.org/data/2.5/weather?q=" + this.CityName + "&units=imperial&apiKey=6ae2281a443225f45f30cc3a4a1d37b2");
        //WeatherConditions wc = (WeatherConditions)gson.fromJson(result, WeatherConditions.class);
        WeatherForecastItem wi = (WeatherForecastItem)gson.fromJson(result, WeatherForecastItem.class);

        //Log.d("TEMPERATURE", );
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.displayToast(String.valueOf(wi.getTemperature()));
            }
        });

    }

    @Override
    public void run() {
     getTemperature();
    }
}
