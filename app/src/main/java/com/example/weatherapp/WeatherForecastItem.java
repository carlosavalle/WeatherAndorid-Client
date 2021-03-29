package com.example.weatherapp;

import java.util.List;
import java.util.Map;

public class WeatherForecastItem {
    private String dt_txt;
    private Map<String, Float> main;
    private WeatherWind wind;
    private List<WeatherDescription> weather;

    public WeatherForecastItem(String dt_txt, Map<String, Float> main, WeatherWind wind, List<WeatherDescription> weather) {
        this.dt_txt = dt_txt;
        this.main = main;
        this.wind = wind;
        this.weather = weather;
    }
    public String getTime (){
        return dt_txt;
    }

    public float getTemperature(){
     return main.get("temp");
    }

    public float getMaxTemp(){
        return main.get("temp_max");
    }


    public String getWeatherCondition(){
        return weather.get(0).getDescription();
    }

    public WeatherWind getWind() {
        return wind;
    }

    @Override
    public String toString() {
        return "WeatherForecastItem{" +
                "dt_txt='" + dt_txt + '\'' +
                ", main=" + main +
                ", wind=" + wind +
                ", weather=" + weather +
                '}';
    }
}
