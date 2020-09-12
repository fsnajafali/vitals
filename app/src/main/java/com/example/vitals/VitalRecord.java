package com.example.vitals;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class VitalRecord {
    public String date;
    public String time;
    public double bloodPressureDiatolic;
    public double bloodPressureSystolic;
    public double bloodSugar;
    public double heartRate;
    public double spo2;
    public double temperature;

    public VitalRecord() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public VitalRecord(String date,
                       String time,
                       double bloodPressureDiatolic,
                       double bloodPressureSystolic,
                       double bloodSugar,
                       double heartRate,
                       double spo2,
                       double temperature) {
        this.date = date;
        this.time = time;
        this.bloodPressureDiatolic = bloodPressureDiatolic;
        this.bloodPressureSystolic = bloodPressureSystolic;
        this.bloodSugar = bloodSugar;
        this.heartRate = heartRate;
        this.spo2 = spo2;
        this.temperature = temperature;
    }

}