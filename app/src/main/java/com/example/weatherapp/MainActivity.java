package com.example.weatherapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    private int mYearIni2, mMonthIni2, mDayIni2, sYearIni2, sMonthIni2, sDayIni2;
    String from,to;
    EditText pickDateFrom,pickDateto;
    Calendar C = Calendar.getInstance();
    int DATE_ID = 0;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //date picker
        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);

        //date picker
        sMonthIni2 = C.get(Calendar.MONTH);
        sDayIni2 = C.get(Calendar.DAY_OF_MONTH);
        sYearIni2 = C.get(Calendar.YEAR);

        pickDateto = (EditText) findViewById(R.id.todate);
        //hide keyboard
        pickDateto.requestFocus();
        pickDateto.setShowSoftInputOnFocus(false);
        pickDateto.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                DATE_ID =1;
                showDialog(DATE_ID);
            }
        });

        pickDateFrom = (EditText) findViewById(R.id.Fromdate);
        //hide keyboard
        pickDateFrom.requestFocus();
        pickDateFrom.setShowSoftInputOnFocus(false);
        pickDateFrom.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                DATE_ID =0;
                showDialog(DATE_ID);
            }
        });


    }
    //set the date to the box
    private void setDate() {
        pickDateFrom.setText(mYearIni + "-" + (mMonthIni + 1) + "-" + mDayIni +" 00:00:00");
        from = mYearIni + "-" + (mMonthIni + 1) + "-" + mDayIni +" 00:00:00";
    }

    //set the date to the box
    private void setDate2() {
        pickDateto.setText(mYearIni2 + "-" + (mMonthIni2 + 1) + "-" + mDayIni2 +" 23:59:59");
        to = mYearIni2 + "-" + (mMonthIni2 + 1) + "-" + mDayIni2 +" 23:59:59";
    }



    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);
            case 1:
                return new DatePickerDialog(this, mDateSetListener2, sYearIni2, sMonthIni2, sDayIni2);
        }

        return null;
    }
    //pick the date
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    setDate();

                }

            };
    //pick the date
    private DatePickerDialog.OnDateSetListener mDateSetListener2 =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni2 = year;
                    mMonthIni2 = monthOfYear;
                    mDayIni2 = dayOfMonth;
                    setDate2();

                }

            };


    public void btn_weatherHistory(View view){
        WeatherHistory weatherHistory = new WeatherHistory(from,to,this);
        //WeatherHistory weatherHistory = new WeatherHistory(((EditText) findViewById(R.id.input_city)).getText().toString(),this);
        weatherHistory.start();
    }
    public void btn_forecast(View view){
       Forecast forecast = new Forecast("Maldonado",this);
        //Forecast forecast = new Forecast(((EditText) findViewById(R.id.input_city)).getText().toString(),this);
       forecast.start();
    }

public void displayToast(String text){
    Toast.makeText(MainActivity.this,"The current temperature is "+text,Toast.LENGTH_LONG).show();
}

public void displayForecast(WeatherForecastSummary[] list){
    ArrayAdapter<WeatherForecastSummary> adapter = new ArrayAdapter<WeatherForecastSummary>(this, android.R.layout.simple_list_item_1,list);
    ListView listView = (ListView) findViewById(R.id.lv_forecast);
    listView.setAdapter(adapter);

}
public void displayHistory(Weather[] list){
        ArrayAdapter<Weather> adapter = new ArrayAdapter<Weather>(this, android.R.layout.simple_list_item_1,list);
        ListView listView = (ListView) findViewById(R.id.lv_forecast);
        listView.setAdapter(adapter);

    }


}