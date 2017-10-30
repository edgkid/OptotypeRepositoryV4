package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Edgar on 07/10/2017.
 */

public class RequestPatient {

    private String request;
    private Context context;

    public RequestPatient(String request, Context context) {
        this.request = request;
        this.context = context;
    }

    public void findPatientsToDay(){


        PatientDbHelper PatientDb = new PatientDbHelper(this.context);
        SQLiteDatabase db = PatientDb.getReadableDatabase();

        Log.d(".....","Consultar");
        Cursor cursor = db.rawQuery("SELECT name FROM patient_db_app", null);

        if (cursor.moveToFirst()){
            Log.d("ss: ","existen datos en la tabla local");
        }else{
            Log.d("nn: ","NO existen datos en la tabla local");
            HttpHandlerPatient httpRequestPatient = new HttpHandlerPatient(request, context);
            httpRequestPatient.connectToResource((DashBoardActivity) context);
        }

    }

    public int CountPatinetsToday (){

        int number = 0;
        PatientDbHelper PatientDb = new PatientDbHelper(this.context);
        SQLiteDatabase db = PatientDb.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT name FROM patient_db_app", null);

        if (cursor.moveToFirst()) {
            do {
                number = cursor.getCount();
            } while(cursor.moveToNext());

        }

        return number;
    }

    public PatientsToday [] TakePatientsToday (){

        int value = 0;
        PatientsToday patientsData[] = new PatientsToday[CountPatinetsToday ()];

        PatientDbHelper PatientDb = new PatientDbHelper(this.context);
        SQLiteDatabase db = PatientDb.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT name, middleName, lastName, maidenName, yearsOld, idPatient  FROM patient_db_app", null);

        if (cursor.moveToFirst()) {
            do {
                PatientsToday patient = new PatientsToday();
                patient.setIdPatient(Integer.parseInt(cursor.getString(5)));
                patient.setName(cursor.getString(0) + " " + cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3));
                patient.setYearsOld(cursor.getString(4));
                patientsData[value] = patient;
                value ++;
            } while(cursor.moveToNext());
        }
        return patientsData;
    }



}
