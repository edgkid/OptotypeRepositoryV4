package com.example.edgar.optotypesystemdevelop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Edgar on 27/10/2017.
 */

public class RequestInteraction {

    private String request;
    private Context context;

    public RequestInteraction(String request, Context context) {
        this.request = request;
        this.context = context;
    }

    public RequestInteraction(Context context) {
        this.context = context;
    }

    public void insertInteractionActivityData(ArrayList<Optotype> optotypes, Patient patient){

        ContentValues newRecord;
        InteractionDbHelper interactionDb = new InteractionDbHelper(this.context);
        SQLiteDatabase db = interactionDb.getWritableDatabase();

        for (Optotype optotype: optotypes) {
            newRecord = new ContentValues();

            newRecord.put(InteractionDbContract.InteractionEntry.OPTOTYPECODE, optotype.getOptotypeCode());
            newRecord.put(InteractionDbContract.InteractionEntry.IDOPTOTYPE, optotype.getIdOptotype());
            newRecord.put(InteractionDbContract.InteractionEntry.IDPATIENT, 1);

            db.insert(InteractionDbContract.InteractionEntry.TABLE_NAME, null, newRecord);
        }

    }


}
