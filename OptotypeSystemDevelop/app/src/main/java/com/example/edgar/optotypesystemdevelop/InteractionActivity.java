package com.example.edgar.optotypesystemdevelop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InteractionActivity extends AppCompatActivity {

    TextView textNames;
    TextView textLastNames;
    TextView textYearsOld;

    ImageView imagePerfil;
    ImageView imageEmotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);

        textNames = (TextView) findViewById(R.id.textViewNAmePatient);
        textLastNames = (TextView) findViewById(R.id.textViewLastnamePatient);
        textYearsOld = (TextView) findViewById(R.id.textYearsPatient);
        imageEmotion = (ImageView) findViewById(R.id.imageInteractionEmotion);
        imagePerfil = (ImageView) findViewById(R.id.imageViewInteractionPatient);

        Intent intentData = getIntent();
        Bundle patientExtras = intentData.getExtras();

        if (patientExtras != null){
            textNames.setText( (String) patientExtras.get("Patient"));
            textLastNames.setText( (String) patientExtras.get("Patient"));
            textYearsOld.setText( (String) patientExtras.get("YearsOld"));
        }




    }
}
