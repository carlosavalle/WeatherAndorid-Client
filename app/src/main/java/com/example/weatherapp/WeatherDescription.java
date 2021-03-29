package com.example.weatherapp;

public class WeatherDescription {
    private String description;

    public WeatherDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "WeatherDescription{" +
                "description='" + description + '\'' +
                '}';
    }
}
