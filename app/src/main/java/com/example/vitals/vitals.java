package com.example.vitals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class vitals extends AppCompatActivity
{
//TO-DO: Integrate firebase to this page
    //resource: https://www.youtube.com/watch?v=71H9-MRXYOE

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitals);

        findViewById(R.id.startvitals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vitals.this, BloodPressure.class);
                vitals.this.startActivity(intent);
            }
        });

        findViewById(R.id.vitalsHistory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vitals.this, VitalHistory.class);
                vitals.this.startActivity(intent);
            }
        });
    }
}