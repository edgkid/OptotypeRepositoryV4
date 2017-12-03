package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Edgar on 03/12/2017.
 */

public class OptoTypeDbAppInitialize {

    Context context;
    Cursor cursor;

    public OptoTypeDbAppInitialize(Context context) {
        this.context = context;
    }

    public void findOrCreteTablePatients (){

        PatientDbHelper patientDb = new PatientDbHelper(this.context);
        SQLiteDatabase db = patientDb.getReadableDatabase();

        try{
            cursor = db.rawQuery("SELECT idPatient FROM " + PatientDbContract.PatientEntry.TABLE_NAME, null);
        }catch (Exception e){
            patientDb.onCreate(db);
        }
    }

    public void findOrCreateTableOptotypes () {

        OptotypeDbHelper optotypeDb = new OptotypeDbHelper(this.context);
        SQLiteDatabase db = optotypeDb.getReadableDatabase();

        try{
            cursor = db.rawQuery("SELECT idOptotype FROM " + OptotypeDbContract.OptotypeEntry.TABLE_NAME, null);
        }catch (Exception e){
            optotypeDb.onCreate(db);
        }
    }


}
