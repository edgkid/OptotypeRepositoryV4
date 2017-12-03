package com.example.edgar.optotypesystemdevelop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Edgar on 18/10/2017.
 */

public class OptotypeDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "OpticalDataBaseApp";

    public OptotypeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql ="";
        ContentValues values = new ContentValues();

        // crear Tablas de base de datos
        sql = sql + "CREATE TABLE " + OptotypeDbContract.OptotypeEntry.TABLE_NAME + " ( ";
        sql = sql + OptotypeDbContract.OptotypeEntry._ID + " INTEGER PRIMARY KEY, ";
        sql = sql + OptotypeDbContract.OptotypeEntry.ID + " TEXT, ";
        sql = sql + OptotypeDbContract.OptotypeEntry.OPTOTYPECODE + " TEXT, ";
        sql = sql + OptotypeDbContract.OptotypeEntry.OPTOTYPENAME + " TEXT, ";
        sql = sql + OptotypeDbContract.OptotypeEntry.IMAGE + " TEXT, ";
        sql = sql + " UNIQUE ( " + OptotypeDbContract.OptotypeEntry.ID + " ) ";
        sql = sql +" ) ";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql ="";
        ContentValues values = new ContentValues();

        // crear Tablas de base de datos
        sql = sql + "CREATE TABLE " + OptotypeDbContract.OptotypeEntry.TABLE_NAME + " ( ";
        sql = sql + OptotypeDbContract.OptotypeEntry._ID + " INTEGER PRIARY KEY, ";
        sql = sql + OptotypeDbContract.OptotypeEntry.ID + " TEXT, ";
        sql = sql + OptotypeDbContract.OptotypeEntry.OPTOTYPECODE + " TEXT, ";
        sql = sql + OptotypeDbContract.OptotypeEntry.OPTOTYPENAME + " TEXT, ";
        sql = sql + OptotypeDbContract.OptotypeEntry.IMAGE + " TEXT, ";
        sql = sql + " UNIQUE ( " + OptotypeDbContract.OptotypeEntry.ID + " ) ";
        sql = sql +" ) ";

        db.execSQL(sql);

    }
}
