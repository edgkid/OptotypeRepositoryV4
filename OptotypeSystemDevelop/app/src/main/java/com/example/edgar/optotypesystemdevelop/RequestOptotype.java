package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Edgar on 02/12/2017.
 */

public class RequestOptotype {

    private String request;
    private Context context;

    public RequestOptotype(String request, Context context) {
        this.request = request;
        this.context = context;
    }

    public void findOptotypes (){

        OptotypeDbHelper optotypeDb = new OptotypeDbHelper(this.context);
        SQLiteDatabase db = optotypeDb.getReadableDatabase();
        Cursor cursor = null;

        Log.d("message: ","Entro en metodo para consultar tabla local de Optotipos");
        try{
            cursor = db.rawQuery("SELECT optotypeName FROM optotype_db_app", null);
        }catch (Exception e){

            optotypeDb.onCreate( db);
            cursor = db.rawQuery("SELECT optotypeName FROM optotype_db_app", null);
        }

        if (cursor.moveToFirst()){
            Log.d("message: ","existen datos en la tabla local");
        }else{
            Log.d("message: ","NO existen datos en la tabla local");
            HttpHandlerOptotype httpRequestOptotype = new HttpHandlerOptotype(request,context);
            httpRequestOptotype.connectToResource((TestActivity)context);
        }
    }


}
