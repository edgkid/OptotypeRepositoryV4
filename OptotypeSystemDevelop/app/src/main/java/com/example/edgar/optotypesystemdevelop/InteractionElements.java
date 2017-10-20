package com.example.edgar.optotypesystemdevelop;

import java.util.ArrayList;

/**
 * Created by Edgar on 20/10/2017.
 */

public class InteractionElements {

    private  ArrayList <Optotype> elements = new ArrayList<Optotype>();

    public InteractionElements() {
    }


    public void fillInteractionElements (){

        // esto sera reemplazado por una consulta
        Optotype optotype = new Optotype ();
        optotype.setIdOptotype("1");
        optotype.setIdOptotypeServer("1");
        optotype.setOptotypeCode("avion_1");
        optotype.setOptotypeName("avion");
        elements.add(optotype);

        optotype.setIdOptotype("2");
        optotype.setIdOptotypeServer("2");
        optotype.setOptotypeCode("barco_1");
        optotype.setOptotypeName("barco");
        elements.add(optotype);

        optotype.setIdOptotype("3");
        optotype.setIdOptotypeServer("3");
        optotype.setOptotypeCode("camion_1");
        optotype.setOptotypeName("camion");
        elements.add(optotype);

        optotype.setIdOptotype("4");
        optotype.setIdOptotypeServer("4");
        optotype.setOptotypeCode("camion_2");
        optotype.setOptotypeName("camion");
        elements.add(optotype);

        optotype.setIdOptotype("5");
        optotype.setIdOptotypeServer("5");
        optotype.setOptotypeCode("circulo_1");
        optotype.setOptotypeName("circulo");
        elements.add(optotype);

        optotype.setIdOptotype("6");
        optotype.setIdOptotypeServer("6");
        optotype.setOptotypeCode("cuadrado_1");
        optotype.setOptotypeName("cuadrado");
        elements.add(optotype);

        optotype.setIdOptotype("7");
        optotype.setIdOptotypeServer("7");
        optotype.setOptotypeCode("naranja_1");
        optotype.setOptotypeName("naranja");
        elements.add(optotype);
        /////////////////////////////////////////////


    }


}
