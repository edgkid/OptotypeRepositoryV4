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

public class TestActivity extends AppCompatActivity {

    TextView textView;
    Context context;

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


    }
}
