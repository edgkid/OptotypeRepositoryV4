package com.example.edgar.optotypesystemdevelop;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    TextView textView;
    Context context;
    ArrayList<String> optotypes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        String value = "";

        context = this;

        textView = (TextView) findViewById(R.id.testActivity);

        /// Para probar información alusiva a la interacción con los optotipos
        /*Intent intentData = getIntent();
        Bundle interactionExtras = intentData.getExtras();

        InteractionDbHelper iDb = new InteractionDbHelper(this.context);
        SQLiteDatabase db = iDb.getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT optotypeCode FROM interaction_db_app", null);

        if (cursor.moveToFirst()){
            do{
                value = value + cursor.getString(0) + " ";
            }while(cursor.moveToNext());

            textView.setText(value);
        }*/


        RequestOptotype requestOptotype = new RequestOptotype("optotypes",context);
        requestOptotype.findOptotypes();
        optotypes = requestOptotype.takeOptotypes();

        for (String element : optotypes){
           Log.d("consumido: ", element);
        }


    }
}
