package com.example.vitals;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;

public class firebasefunctions {
    private DatabaseReference mDatabase;
    public void readFBData() {
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
    }

    public void writeFBData(VitalRecord newVitalRecord) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
//        VitalRecord newVitalRecord = new VitalRecord("d", "t", 0, 0, 0, 0, 0, 0.0);

        DatabaseReference newVitalsRef = mDatabase.push();

        newVitalsRef.setValue(newVitalRecord);
    }
}
