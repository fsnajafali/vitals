package com.example.vitals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.net.Uri;
import android.Manifest;
import android.content.pm.PackageManager;


public class MainActivity extends AppCompatActivity {
    private Button button;

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
                //Intent intent = new Intent(MainActivity.this, locate.class);
               // MainActivity.this.startActivity(intent);
            }
        });

        //button to call 911
        //resource to look at: https://www.tutorialspoint.com/android/android_phone_calls.htm
        button = (Button) findViewById(R.id.emergency);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0377778888"));

                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

    }
}