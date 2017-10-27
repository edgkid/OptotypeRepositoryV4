package com.example.edgar.optotypesystemdevelop;

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

        context = this;

        textView = (TextView) findViewById(R.id.testActivity);

        Intent intentData = getIntent();
        Bundle interactionExtras = intentData.getExtras();

        InteractionDbHelper iDb = new InteractionDbHelper(this.context);
        SQLiteDatabase db = iDb.getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT optotypeCode FROM interaction_db_app", null);
        if (cursor.moveToFirst()){
            textView.setText( "Datos Registrados");
        }else{
            textView.setText( "Datos no registrados");
        }


    }
}
