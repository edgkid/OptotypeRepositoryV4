package com.example.edgar.optotypesystemdevelop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textView = (TextView) findViewById(R.id.testActivity);

        Intent intentData = getIntent();
        Bundle interactionExtras = intentData.getExtras();


        if (interactionExtras != null){
            textView.setText( (String) interactionExtras.get("optoPrueba"));
        }


    }
}
