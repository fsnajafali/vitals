package com.example.vitals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class vitals extends AppCompatActivity {
    //TO-DO: Integrate firebase to this page
    //resource: https://www.youtube.com/watch?v=71H9-MRXYOE
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitals);

        // FIREBASE READING STUFF
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final LinkedList<VitalRecord> vitalsRecords = new LinkedList<VitalRecord>();

        ValueEventListener readVitalListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    DataSnapshot vitalPath = child;
                    vitalsRecords.add(new VitalRecord(
                            "date",
                            "time",
                            (long) vitalPath.child("bloodPressureDiatolic").getValue(),
                            (long) vitalPath.child("bloodPressureSystolic").getValue(),
                            (long) vitalPath.child("bloodSugar").getValue(),
                            (long) vitalPath.child("heartRate").getValue(),
                            (long) vitalPath.child("spo2").getValue(),
                            (long) vitalPath.child("temperature").getValue()
                            ));
                }
            }

            @Override
            public void onCancelled(DatabaseError vitalListener) {
            }
        };
        mDatabase.addValueEventListener(readVitalListener);
        System.out.println(vitalsRecords);
        // END OF FIREBASE READING STUFF
    }
}