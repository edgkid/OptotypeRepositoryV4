package com.example.edgar.optotypesystemdevelop;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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

    TextView textDebug;

    InteractionElements elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);

        elements = new InteractionElements();
        elements.fillInteractionElements();
        textDebug = (TextView) findViewById(R.id.textDebug);

        textNames = (TextView) findViewById(R.id.textViewNAmePatient);
        textLastNames = (TextView) findViewById(R.id.textViewLastnamePatient);
        textYearsOld = (TextView) findViewById(R.id.textYearsPatient);

        imageOptotype = (ImageView) findViewById(R.id.imageViewOptotype);
        imageEmotion = (ImageView) findViewById(R.id.imageInteractionEmotion);
        imagePerfil = (ImageView) findViewById(R.id.imageViewInteractionPatient);

        imageOptotypeA = (ImageView) findViewById(R.id.imageOptotypeOptionA);
        imageOptotypeB = (ImageView) findViewById(R.id.imageOptotypeOptionB);
        imageOptotypeC = (ImageView) findViewById(R.id.imageOptotypeOptionC);


        imageOptotype.setOnLongClickListener(logClickListener);

        imageOptotypeA.setOnDragListener(dragListenerA);
        imageOptotypeB.setOnDragListener(dragListenerB);
        imageOptotypeC.setOnDragListener(dragListenerC);

        Intent intentData = getIntent();
        Bundle patientExtras = intentData.getExtras();

        if (patientExtras != null){
            textNames.setText( (String) patientExtras.get("Patient"));
            textLastNames.setText( (String) patientExtras.get("Patient"));
            textYearsOld.setText( (String) patientExtras.get("YearsOld") + " años");

            refreshInteractionActivity();

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

    View.OnDragListener dragListenerA = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            actionDrag(dragEvent, view, 1);

            return true;
        }
    };

    View.OnDragListener dragListenerB = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            actionDrag(dragEvent, view, 2);

            return true;
        }
    };

    View.OnDragListener dragListenerC = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            actionDrag(dragEvent, view, 3);

            return true;
        }
    };

    public void actionDrag (int dragEvent, View view, int option){

        switch (dragEvent){
            //Accion para mover elemento
            case DragEvent.ACTION_DRAG_ENTERED:
                //identificar si es correcta la selección
                if (option == 1 ) {
                    if (imageOptotypeA.getTag().equals(imageOptotype.getTag()))
                        imageOptotypeA.setBackgroundColor(Color.rgb(0,255,102));
                    else
                        imageOptotypeA.setBackgroundColor(Color.rgb(183,28,28));
                }else if(option == 2){
                    if (imageOptotypeB.getTag().equals(imageOptotype.getTag()))
                        imageOptotypeB.setBackgroundColor(Color.rgb(0,255,102));
                    else
                        imageOptotypeB.setBackgroundColor(Color.rgb(183,28,28));
                }else if (option == 3){
                    if (imageOptotypeC.getTag().equals(imageOptotype.getTag()))
                        imageOptotypeC.setBackgroundColor(Color.rgb(0,255,102));
                    else
                        imageOptotypeC.setBackgroundColor(Color.rgb(183,28,28));
                }
                break;

            case DragEvent.ACTION_DRAG_EXITED:

                if (option == 1 ) {
                    imageOptotypeA.setBackgroundColor(Color.rgb(255,255,255));
                }else if(option == 2){
                    imageOptotypeB.setBackgroundColor(Color.rgb(255,255,255));
                }else if (option == 3){
                    imageOptotypeC.setBackgroundColor(Color.rgb(255,255,255));
                }

                break;
            case DragEvent.ACTION_DROP:

                //accionar sobre el elemeno seleccionado

                if (option == 1) {
                    textDebug.setText("solto sobre Option A");
                    imageOptotypeA.setBackgroundColor(Color.rgb(255,255,255));
                }else if (option == 2){
                    textDebug.setText("solto sobre Option B");
                    imageOptotypeB.setBackgroundColor(Color.rgb(255,255,255));
                }else if (option == 3){
                    textDebug.setText("solto sobre Option C");
                    imageOptotypeC.setBackgroundColor(Color.rgb(255,255,255));
                }

                refreshInteractionActivity();

                break;
        }
    }

    public void refreshInteractionActivity(){

        String image;
        String resource = "drawable";
        int position = 0;
        int sizeElements = 0;

        Double number = Math.floor(Math.random() * elements.getElements().size());
        position = number.intValue();
        sizeElements = elements.getElements().size();
        Log.d("message: ", String.valueOf(position));

        image = elements.getElements().get(position).getOptotypeCode();
        imageOptotype.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
        imageOptotype.setTag(1);
        assignOptotypeOptions(position, sizeElements, image, resource);

    }

    public void assignOptotypeOptions(int position, int size, String image, String resource){

        if (elements.primeNumber(position, size) && elements.evenNumber(position)){

            imageOptotypeA.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeA.setTag(1);
            if (size != 1 )
                elements.getElements().remove(position);
            position ++;
            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeB.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeB.setTag(2);
            position ++;
            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeC.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeC.setTag(3);

        }else if (elements.primeNumber(position, size) || ! elements.evenNumber(position)){

            imageOptotypeC.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeC.setTag(1);
            if (size != 1 )
                elements.getElements().remove(position);
            position ++;
            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeB.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeB.setTag(2);
            position ++;
            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeA.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeA.setTag(3);

        }else{

            imageOptotypeB.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeB.setTag(1);
            if (size != 1 )
                elements.getElements().remove(position);
            position ++;
            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeA.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeA.setTag(2);
            position ++;
            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeC.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeC.setTag(3);

        }

    }

    public void compareImageView (){

    }


}
