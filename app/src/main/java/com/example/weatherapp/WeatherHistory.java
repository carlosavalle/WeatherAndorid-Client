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

        
        String result = ReadJSON.readHTTP("http://192.168.2.213:8080/WeatherServer_war/weather?startDate="+sDate+"&endDate="+eDate+"");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Weather[] w = mapper.readValue(result, Weather[].class);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (sDate != null && eDate != null) {
                    activity.displayHistory(w);
                }else{
                    activity.displayToast(String.valueOf("Enter valid dates"));
                }

            }
        });

    }

}
