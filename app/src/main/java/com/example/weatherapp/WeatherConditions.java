package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class WeatherConditions {
    private int id;
    private String name;

    @SerializedName("main")
    private Map<String, Float> measurements;

    public WeatherConditions(int id, String name, Map<String, Float> main) {
        this.id = id;
        this.name = name;
        this.measurements = main;
    }

    @Override
    public String toString() {
        return "WeatherConditions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", main=" + measurements +
                '}';
    }
}
