package com.example.edgar.optotypesystemdevelop;

import android.content.ClipData;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InteractionActivity extends AppCompatActivity {

    TextView textNames;
    TextView textLastNames;
    TextView textYearsOld;

    ImageView imageOptotype;
    ImageView imagePerfil;
    ImageView imageEmotion;

    ImageView imageOptotypeA;
    ImageView imageOptotypeB;
    ImageView imageOptotypeC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);

        textNames = (TextView) findViewById(R.id.textViewNAmePatient);
        textLastNames = (TextView) findViewById(R.id.textViewLastnamePatient);
        textYearsOld = (TextView) findViewById(R.id.textYearsPatient);

        imageOptotype = (ImageView) findViewById(R.id.imageViewOptotype);
        imageEmotion = (ImageView) findViewById(R.id.imageInteractionEmotion);
        imagePerfil = (ImageView) findViewById(R.id.imageViewInteractionPatient);

        imageOptotypeA = (ImageView) findViewById(R.id.imageOptotypeOptionA);
        imageOptotypeA = (ImageView) findViewById(R.id.imageOptotypeOptionB);
        imageOptotypeA = (ImageView) findViewById(R.id.imageOptotypeOptionC);


        imageOptotype.setOnLongClickListener(logClickListener);


        Intent intentData = getIntent();
        Bundle patientExtras = intentData.getExtras();

        if (patientExtras != null){
            textNames.setText( (String) patientExtras.get("Patient"));
            textLastNames.setText( (String) patientExtras.get("Patient"));
            textYearsOld.setText( (String) patientExtras.get("YearsOld") + " años");
        }
    }

    View.OnLongClickListener  logClickListener = new View.OnLongClickListener() {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public boolean onLongClick(View v) {

            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                v.startDragAndDrop(data,myShadowBuilder,v,0);
            } else {
                v.startDrag(data,myShadowBuilder,v,0);
            }

            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            Log.d("message: ", "Drag");
            final View view = (View) event.getLocalState();
            switch (dragEvent){
                //Accion para mover elemento
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    break;


            }
            return true;
        }
    };

}
