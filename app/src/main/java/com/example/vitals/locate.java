package com.example.vitals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class locate extends AppCompatActivity {
//this class is where the MapBox API will be implemented
    //resource: https://docs.mapbox.com/help/tutorials/markers/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate);
    }
}