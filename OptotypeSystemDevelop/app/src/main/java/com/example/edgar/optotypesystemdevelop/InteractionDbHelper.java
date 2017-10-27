package com.example.edgar.optotypesystemdevelop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Edgar on 27/10/2017.
 */

public class InteractionDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "OpticalDataBaseApp";

    public InteractionDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql ="";
        ContentValues values = new ContentValues();

        // crear Tablas de base de datos
        sql = sql + "CREATE TABLE " + InteractionDbContract.InteractionEntry.TABLE_NAME + " ( ";
        sql = sql + InteractionDbContract.InteractionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql = sql + InteractionDbContract.InteractionEntry.ID + " TEXT, ";
        sql = sql + InteractionDbContract.InteractionEntry.IDOPTOTYPE + " TEXT, ";
        sql = sql + InteractionDbContract.InteractionEntry.IDPATIENT + " TEXT, ";
        sql = sql + InteractionDbContract.InteractionEntry.OPTOTYPECODE + " TEXT, ";
        sql = sql + " UNIQUE ( " + InteractionDbContract.InteractionEntry.ID + " ) ";
        sql = sql +" ) ";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql ="";
        ContentValues values = new ContentValues();

        // crear Tablas de base de datos
        sql = sql + "CREATE TABLE " + InteractionDbContract.InteractionEntry.TABLE_NAME + " ( ";
        sql = sql + InteractionDbContract.InteractionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql = sql + InteractionDbContract.InteractionEntry.ID + " TEXT, ";
        sql = sql + InteractionDbContract.InteractionEntry.IDOPTOTYPE + " TEXT, ";
        sql = sql + InteractionDbContract.InteractionEntry.IDPATIENT + " TEXT, ";
        sql = sql + InteractionDbContract.InteractionEntry.OPTOTYPECODE + " TEXT, ";
        sql = sql + " UNIQUE ( " + InteractionDbContract.InteractionEntry.ID + " ) ";
        sql = sql +" ) ";

        db.execSQL(sql);


    }
}
