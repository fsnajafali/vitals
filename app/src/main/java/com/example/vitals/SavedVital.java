package com.example.vitals;

public class SavedVital {
    private static SavedVital mInstance= null;

    public VitalRecord vitalRecord = new VitalRecord("d", "t", 0, 0, 0, 0, 0, 0.0);;

    protected SavedVital(){}

    public static synchronized SavedVital getInstance() {
        if(null == mInstance){
            mInstance = new SavedVital();
        }
        return mInstance;
    }
}
