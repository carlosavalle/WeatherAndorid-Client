package com.example.weatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void btn_temperature(View view){
        Temperature temperature = new Temperature(((EditText) findViewById(R.id.input_city)).getText().toString(),this);
        temperature.start();
    }
    public void btn_forecast(View view){
       Forecast forecast = new Forecast(((EditText) findViewById(R.id.input_city)).getText().toString(),this);
       forecast.start();
    }

public void displayToast(String text){
    Toast.makeText(MainActivity.this,"The current temperature is "+text,Toast.LENGTH_LONG).show();
}

public void displayForecast(ArrayList<WeatherForecastSummary> list){
    ArrayAdapter<WeatherForecastSummary> adapter = new ArrayAdapter<WeatherForecastSummary>(this, android.R.layout.simple_list_item_1,list);
    ListView listView = (ListView) findViewById(R.id.lv_forecast);
    listView.setAdapter(adapter);

}


}