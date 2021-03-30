package com.example.weatherapp;


import java.util.Date;


public class Weather {

    private int idWeather;
    private Date date;
    private int idLocation;
    private String name;
    private float temp;
    private float humidity;
    private float windSpeed;
    private float pressure;
    private String weatherDescription;
    private String weatherIcon;
    private float rain;



    public int getIdWeather() {
        return idWeather;
    }

    public void setIdWeather(int idWeather) {
        this.idWeather = idWeather;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    @Override
    public String toString() {
        return "" +
                "Date= " + date +
                ", Location= " + name +
                ", Temp F=" + temp +
                ", Humidity=" + humidity +
                ", Wind Speed=" + windSpeed +
                ", Pressure=" + pressure +
                ", Weather='" + weatherDescription + '\'' +
                ", Rain=" + rain +
                "";
    }


}
