package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Edgar on 02/12/2017.
 */

public class RequestOptotype {

    private String request;
    private Context context;

    public RequestOptotype(Context context) {

    }

    public RequestOptotype(String request, Context context) {
        this.request = request;
        this.context = context;
    }

    public void findOptotypes (){

        OptotypeDbHelper optotypeDb = new OptotypeDbHelper(this.context);
        SQLiteDatabase db = optotypeDb.getReadableDatabase();
        Cursor cursor = null;

        cursor = db.rawQuery("SELECT optotypeName FROM " + OptotypeDbContract.OptotypeEntry.TABLE_NAME, null);
        Log.d("message: ","Entro en metodo para consultar tabla local de Optotipos");

        if (cursor.moveToFirst()){
            Log.d("message: ","existen datos en la tabla local");
        }else{
            Log.d("message: ","NO existen datos en la tabla local");
            HttpHandlerOptotype httpRequestOptotype = new HttpHandlerOptotype(request,context);
            httpRequestOptotype.connectToResource((TestActivity)context);
        }
    }

    public ArrayList<String> takeOptotypes (){

        OptotypeDbHelper optotypeDb = new OptotypeDbHelper( this.context);
        SQLiteDatabase db = optotypeDb.getReadableDatabase();
        Cursor cursor = null;
        ArrayList<String> optotypesCode = new ArrayList<String>();
        String value = "";

        cursor = db.rawQuery("SELECT optotypeCode FROM " + OptotypeDbContract.OptotypeEntry.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                value = String.valueOf(cursor.getString(0));
                //Log.d("cursor: ", value );
                optotypesCode.add(value);
            } while(cursor.moveToNext());
        }else {
            Log.d("message: ", "NO se lee registro");
        }

        return optotypesCode;
    }


}
