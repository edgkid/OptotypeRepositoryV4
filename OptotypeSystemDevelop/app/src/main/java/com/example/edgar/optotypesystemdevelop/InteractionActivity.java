package com.example.edgar.optotypesystemdevelop;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

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
    TextView textDebugB;

    Interaction controlInteraction;
    InteractionElements elements;
    Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);

        controlInteraction = new Interaction();
        elements = new InteractionElements();
        elements.fillInteractionElements();


        textDebug = (TextView) findViewById(R.id.textDebug);
        textDebugB = (TextView) findViewById(R.id.textDebug2);

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
                        imageOptotypeA.setBackgroundColor(Color.rgb(0, 255, 102));
                    else
                        imageOptotypeA.setBackgroundColor(Color.rgb(183,28,28));
                }else if(option == 2){
                    if (imageOptotypeB.getTag().equals(imageOptotype.getTag()))
                        imageOptotypeB.setBackgroundColor(Color.rgb(0, 255, 102));
                    else
                        imageOptotypeB.setBackgroundColor(Color.rgb(183,28,28));
                }else if (option == 3){
                    if (imageOptotypeC.getTag().equals(imageOptotype.getTag()))
                        imageOptotypeC.setBackgroundColor(Color.rgb(0, 255, 102));
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

                if (option == 1 ) {
                    if (imageOptotypeA.getTag().equals(imageOptotype.getTag()))
                        workWithRealOption(imageOptotype, imageOptotypeA);
                    else
                        workWithBackOption(imageOptotype, imageOptotypeA);
                }else if(option == 2){
                    if (imageOptotypeB.getTag().equals(imageOptotype.getTag()))
                        workWithRealOption(imageOptotype, imageOptotypeB);
                    else
                        workWithBackOption(imageOptotype, imageOptotypeB);
                }else if (option == 3){
                    if (imageOptotypeC.getTag().equals(imageOptotype.getTag()))
                        workWithRealOption(imageOptotype, imageOptotypeC);
                    else
                        workWithBackOption(imageOptotype, imageOptotypeC);
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
        imageOptotype.setTag(image);
        assignOptotypeOptions(position, sizeElements, image, resource);

    }

    public void assignOptotypeOptions(int position, int size, String image, String resource){

        if (elements.primeNumber(position, size) && elements.evenNumber(position)){

            imageOptotypeA.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeA.setTag(image);

            position ++;
            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeB.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeB.setTag(image);
            position ++;
            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeC.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeC.setTag(image);

        }else if (elements.primeNumber(position, size) || ! elements.evenNumber(position)){

            imageOptotypeC.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeC.setTag(image);

            position ++;
            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeB.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeB.setTag(image);
            position ++;

            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeA.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeA.setTag(image);

        }else{

            imageOptotypeB.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeB.setTag(image);

            position ++;
            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeA.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeA.setTag(image);

            position ++;
            image = elements.getElements().get(elements.validateElements(position, size)).getOptotypeCode();
            imageOptotypeC.setImageResource(this.getResources().getIdentifier(image, resource, this.getPackageName()));
            imageOptotypeC.setTag(image);

        }

    }

    public void workWithRealOption (ImageView optotype, ImageView option){

        int sizeElements =0;
        int total = 0;
        option.setBackgroundColor(Color.rgb(255, 255, 255));
        /*textDebug.setText(optotype.getTag().toString());
        textDebugB.setText(option.getTag().toString());*/

        ArrayList<Optotype> optotypes = elements.getElements();
        Iterator<Optotype> iterator = optotypes.iterator();

        total = controlInteraction.getTotalOptotypes();

        while (iterator.hasNext()){

            if (iterator.next().getOptotypeCode().equals(optotype.getTag())){
                total ++;
                controlInteraction.setTotalOptotypes(total);
                textDebugB.setText(Integer.toString(controlInteraction.getTotalOptotypes()));
                controlInteraction.getOptotypes().add(optotypes.get(sizeElements));
                if (sizeElements != 0 ) {
                    controlInteraction.setTotalOptotypes(total);
                    elements.getElements().remove(sizeElements);
                }
                break;
            }
            sizeElements ++;

            if (controlInteraction.getTotalOptotypes() == 12){

                Intent testActivity = new Intent(this, TestActivity.class);
                testActivity.putExtra("optoPrueba",controlInteraction.getOptotypes().get(4).getOptotypeName());
                startActivity(testActivity);
                /*RequestInteraction requestInteraction = new RequestInteraction(this);
                requestInteraction.insertInteractionActivityData(controlInteraction.getOptotypes(), patient);*/
            }
        }
    }

    public void workWithBackOption (ImageView optotype, ImageView option){
        option.setBackgroundColor(Color.rgb(255, 255, 255));
    }


}
