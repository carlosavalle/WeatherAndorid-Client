package com.example.weatherapp;

import java.util.Comparator;

public class WeatherForecastSummary {
    private String dt_txt;
    private String location;
    private float maxTemp;
    private float maxWind;
    private String weatherCondition;
    private float rain;

    public WeatherForecastSummary() {
    }

    public WeatherForecastSummary(String dt_txt, String location, float maxTemp, float maxWind, String weatherCondition, float rain) {
        this.dt_txt = dt_txt;
        this.location = location;
        this.maxTemp = maxTemp;
        this.maxWind = maxWind;
        this.weatherCondition = weatherCondition;
        this.rain = rain;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public float getMaxWind() {
        return maxWind;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public void setMaxWind(float maxWind) {
        this.maxWind = maxWind;
    }

    public String getLocation() {
        return location;
    }

    public float getRain() {
        return rain;
    }

    @Override
    public String toString() {
        return   "Date=" + dt_txt +
                ", location=" + location  +
                ", maxTemp=" + maxTemp +
                ", maxWind=" + maxWind +
                ", weatherCondition=" + weatherCondition  +
                ", rain=" + rain +
                "";
    }
}
