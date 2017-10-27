package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    public void insertInteractionActivityData(){

        InteractionDbHelper interactionDb = new InteractionDbHelper(this.context);
        SQLiteDatabase db = interactionDb.getWritableDatabase();

    }


}
