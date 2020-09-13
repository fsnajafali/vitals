package com.example.vitals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baoyachi.stepview.HorizontalStepView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.vitals.R.layout.activity_bloodpressure;

public class VitalHistory extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_history);

        // next up button to another page
//        findViewById(R.id.nextupbtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(BloodGlucose.this, ReviewPage.class);
//                BloodGlucose.this.startActivity(intent);
//            }
//        });

        WebView browser = (WebView) findViewById(R.id.webview);
        browser.loadUrl("https://vitals-858d7.web.app/");

    }
}