package com.example.weatherapp;

import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.List;

public class WeatherHistory extends Thread {
    private String sDate,eDate;
    private MainActivity activity;

    public WeatherHistory(String sDate,String eDate , MainActivity activity) {
        this.sDate = sDate;
        this.eDate = eDate;
        this.activity = activity;
    }
    @Override
    public void run() {
        try {
            getWeatherHistory();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public void getWeatherHistory() throws JsonProcessingException {


        Log.d("Temperature","it is getting the temperature for that city on a background thread");
        String result = ReadJSON.readHTTP("http://192.168.2.213:8080/WeatherServer_war/weather?startDate="+sDate+"&endDate="+eDate+"");
        //    String result = ReadJSON.readHTTP("http://192.168.2.213:8080/WeatherServer_war/weather?startDate=2021-03-29 08:34:55&endDate=2021-03-29 23:34:55");
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Weather[] w = mapper.readValue(result, Weather[].class);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.displayHistory(w);
            }
        });

    }

}
