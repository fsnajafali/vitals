package com.example.vitals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baoyachi.stepview.HorizontalStepView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.vitals.R.layout.activity_bloodpressure;

public class ReviewPage extends AppCompatActivity
{
//TO-DO: Integrate firebase to this page
    //resource: https://www.youtube.com/watch?v=71H9-MRXYOE

    TextView dateTime;
    TextView resultDateTime;
    TextView resultSystolic, resultDiastollic;
    TextView resultHeartRate;
    TextView resultSP02;
    TextView resultTemperature;
    TextView resultBloodglucose;
    // HorizontalStepView horizontalStepView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewpage);

        // next up button to vitals history page
//        findViewById(R.id.nextupbtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ReviewPage.this, VitalHistory.class);
//                ReviewPage.this.startActivity(intent);
//            }
//        });

        findViewById(R.id.btnArrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewPage.this, BloodGlucose.class);
                ReviewPage.this.startActivity(intent);
            }
        });

        dateTime = findViewById(R.id.dateTime);

        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.LONG).format(currentTime);

        formattedDate = formattedDate + " " + DateFormat.getTimeInstance().format(currentTime);

        dateTime.setText(formattedDate);

        String shortDate = DateFormat.getDateInstance(DateFormat.SHORT).format(currentTime);
        shortDate = shortDate + " " + DateFormat.getTimeInstance().format(currentTime);

        resultDateTime = findViewById(R.id.resultDateTime);
        resultDateTime.setText(shortDate);

        resultSystolic = (TextView) findViewById(R.id.resultSystolic);
        resultDiastollic = (TextView) findViewById(R.id.resultDiastollic);

        resultSystolic.setText(getIntent().getExtras().getString("SYSTOLIC") + " mmHg");
        resultDiastollic.setText(getIntent().getExtras().getString("DIASTOLLIC") + " mmHg");

        resultHeartRate = (TextView) findViewById(R.id.resultHearRate);

        resultHeartRate.setText(getIntent().getExtras().getString("HEARTRATE") + " beats/min");

        resultSP02 = (TextView) findViewById(R.id.resultSP02);

        resultSP02.setText(getIntent().getExtras().getString("SP02") + " %");

        resultTemperature = (TextView) findViewById(R.id.resultTemperature);

        resultTemperature.setText(getIntent().getExtras().getString("TEMPERATURE") + " \\u2109");

        resultBloodglucose = (TextView) findViewById(R.id.resultBloodglucose);

        resultBloodglucose.setText(getIntent().getExtras().getString("BLOODGLUCOSE") + " mg/dL");

//        Log.d("myLog", shortDate);
//        System.out.println(shortDate);

//        horizontalStepView = (HorizontalStepView)findViewById(R.id.horizontalStepView);
//        List<String> steps = new ArrayList<>();
//        steps.add("1");
//        steps.add("2");
//        steps.add("3");
//        steps.add("4");
//        steps.add("5");
//        steps.add("6");
//
//        // horizontalStepView.setStepViewTexts(steps);
//        horizontalStepView.setTextSize(12);

    }
}