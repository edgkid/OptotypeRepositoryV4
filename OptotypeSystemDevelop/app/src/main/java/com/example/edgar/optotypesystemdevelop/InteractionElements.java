package com.example.edgar.optotypesystemdevelop;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/**
 * Created by Edgar on 20/10/2017.
 */

public class InteractionElements {

    private  ArrayList <Optotype> elements = new ArrayList<Optotype>();

    public InteractionElements() {
    }

    public ArrayList<Optotype> getElements() {
        return elements;
    }

    public void fillInteractionElements (){

        ArrayList <String> optotypes = new ArrayList<String>();
        Optotype optotype;
        // esto sera reemplazado por una consulta
        int count = 1;
        optotypes.add("avion_1");
        optotypes.add("camion_1");
        optotypes.add("camion_2");
        optotypes.add("naranja_1");
        optotypes.add("barco_1");
        optotypes.add("helado_1");
        optotypes.add("telefono_1");
        optotypes.add("triangulo_1");
        optotypes.add("cuadrado_1");
        optotypes.add("sol_1");
        optotypes.add("estrella_1");
        optotypes.add("corazon_1");
        optotypes.add("casa_1");
        optotypes.add("bonbillo_1");
        /////////////////////////////////////////////

        for (String element : optotypes){
            optotype = new Optotype();
            optotype.setIdOptotype(Integer.toString(count));
            optotype.setOptotypeName(element);
            optotype.setOptotypeCode(element);
            count++;
            elements.add(optotype);
        }

    }


    //metodo para probar llenado de elementos
    public void viewInteractionElements(){

        Log.d("message: ", "size = " + this.elements.size());

    }

    public int validateElements (int position, int sizeElements){

        if ((position + 1 >= sizeElements)){
            position = 0;
        }

        return position;
    }

    public boolean evenNumber (int position){

        boolean value = false;

        if ((position % 2) == 0){
            value = true;
        }

        return value;
    }

    public boolean primeNumber(int position, int size){

        boolean value = false;
        int results = 0;

        for (int i = 1; i<=size; i++){

            if (position % i == 0)
                results ++;
            if (results > 2){
                value = true;
                break;
            }
        }

        return value;
    }

}
