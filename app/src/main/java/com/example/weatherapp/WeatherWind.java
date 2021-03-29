package com.example.weatherapp;

public class WeatherWind {
    private float speed;

    public WeatherWind(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "WeatherWind{" +
                "speed=" + speed +
                '}';
    }
}