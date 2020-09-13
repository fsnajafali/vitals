package com.example.vitals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baoyachi.stepview.HorizontalStepView;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.vitals.R.layout.activity_bloodpressure;

public class SP02 extends AppCompatActivity
{
//TO-DO: Integrate firebase to this page
    //resource: https://www.youtube.com/watch?v=71H9-MRXYOE

    TextView dateTime;
    EditText input;
    // HorizontalStepView horizontalStepView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp02);

        input = findViewById(R.id.input);

        // next up button to another page
        findViewById(R.id.nextupbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SP02.this, Temperature.class);
                String sp02 = input.getText().toString();
                intent.putExtra("SP02", sp02);
                SP02.this.startActivity(intent);
            }
        });

        findViewById(R.id.btnArrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SP02.this, HeartRate.class);
                SP02.this.startActivity(intent);
            }
        });

        dateTime = findViewById(R.id.dateTime);

        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.LONG).format(currentTime);
        formattedDate = formattedDate + " " + DateFormat.getTimeInstance().format(currentTime);

        dateTime.setText(formattedDate);

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