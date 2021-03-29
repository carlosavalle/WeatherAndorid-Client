package com.example.weatherapp;

import java.util.Comparator;

public class WeatherForecastSummary {
    private String dt_txt;
    private float maxTemp;
    private float maxWind;
    private String weatherCondition;

    public WeatherForecastSummary(String dt_txt, float maxTemp, float maxWind, String weatherCondition) {
        this.dt_txt = dt_txt;
        this.maxTemp = maxTemp;
        this.maxWind = maxWind;
        this.weatherCondition = weatherCondition;
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
// compared to sort the array to Max Temp
    public static Comparator<WeatherForecastSummary> sortMaxTemp = new Comparator<WeatherForecastSummary>() {
        @Override
        public int compare(WeatherForecastSummary o1, WeatherForecastSummary o2) {
            return Float.compare(o2.getMaxTemp(),o1.getMaxTemp());
        }
    };
    // compared to sort the array to Max Wind
    public static Comparator<WeatherForecastSummary> sortMaxWind = new Comparator<WeatherForecastSummary>() {
        @Override
        public int compare(WeatherForecastSummary o1, WeatherForecastSummary o2) {
            return Float.compare(o2.getMaxWind(),o1.getMaxWind());
        }
    };


    @Override
    public String toString() {
        return
                "Date Time='" + dt_txt + '\'' +
                ", maxTemp=" + maxTemp +
                ", maxWind=" + maxWind +
                ", weatherCondition='" + weatherCondition + '\'' ;
    }
}
