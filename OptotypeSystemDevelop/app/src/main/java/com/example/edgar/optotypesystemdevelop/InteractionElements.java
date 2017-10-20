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
            optotype.setIdOptotype("1");
            optotype.setIdOptotypeServer("1");
            optotype.setOptotypeName(element);
            optotype.setOptotypeCode(element);

            elements.add(optotype);
        }

    }


    //metodo para probar llenado de elementos
    public void viewInteractionElements(){

        Log.d("message: ", "size = " + this.elements.size());

    }

    public int validateElements (int position, int sizeElements){

        if ((position + 1 >= sizeElements)){
            position = 1;
        }

        return position;
    }


}
