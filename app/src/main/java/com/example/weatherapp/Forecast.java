package com.example.weatherapp;

import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        try {
            getForecast();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void getForecast() throws JsonProcessingException {

        Log.d("Forecast","it is getting the Forecast for that city on a background thread");

        String result = ReadJSON.readHTTP("http://192.168.2.213:8080/WeatherServer_war/forecast");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        WeatherForecastSummary[] w = mapper.readValue(result, WeatherForecastSummary[].class);





        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
            activity.displayForecast(w);
            }
        });

    }
}
