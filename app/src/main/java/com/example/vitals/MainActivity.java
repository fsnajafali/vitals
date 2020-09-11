package com.example.vitals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button to navigate vitals page
        findViewById(R.id.vitals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, vitals.class);
                MainActivity.this.startActivity(intent);
            }
        });
        //button to navigate to location page
        findViewById(R.id.locate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, locate.class);
                MainActivity.this.startActivity(intent);
            }
        });
        //button to call 911
        //resource to look at: https://www.tutorialspoint.com/android/android_phone_calls.htm

    }
}