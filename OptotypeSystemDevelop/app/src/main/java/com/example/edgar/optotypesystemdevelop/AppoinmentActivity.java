package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class AppoinmentActivity extends AppCompatActivity {

    Button logOut;
    ImageView imageUser;
    // TextView userName;

    ListView listViewAppoinmnet;
    Context contextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinment);

        contextActivity = this;
        logOut = (Button) findViewById(R.id.buttonLogout);
        imageUser = (ImageView) findViewById(R.id.imageViewLoginUser);
        listViewAppoinmnet = (ListView) findViewById(R.id.listViewAppoinment);

        loadAppoinment();

    }

    public void loadAppoinment (){

        // Se remplazar por el consumo de un recurso, el recurso ya existe
        PatientsToday patiensData[] = new PatientsToday[]{
                new PatientsToday("Edgar Rafel Landaeta Malave","4",R.drawable.usuario_icon),
                new PatientsToday("Gabriel Andres Landaeta Eljuri","3",R.drawable.usuario_icon),
                new PatientsToday("Juan Francisco Landaeta Eljuri","5",R.drawable.usuario_icon),
                new PatientsToday("Adira Yadira Quintero Sanchez","3",R.drawable.usuario_icon),
                new PatientsToday("Kimberly Carolina Iriearte Perozo","4",R.drawable.usuario_icon),
                new PatientsToday("Victor Alejandro Landaeta Landaeta","4",R.drawable.usuario_icon),
                new PatientsToday("Abrahan Rafel Castillo Pernia","3",R.drawable.usuario_icon),
                new PatientsToday("Jesus Gabriel Moreno Campo","5",R.drawable.usuario_icon),
                new PatientsToday("Victoria Coromoto Malave Campo","5",R.drawable.usuario_icon),
                new PatientsToday("Jessica Maria Guzman Palacio","3",R.drawable.usuario_icon),
                new PatientsToday("Gabriela Maria Gimenes Arroyo","4",R.drawable.usuario_icon),
                new PatientsToday("Cesar Alejandro Galindo Guerra","4",R.drawable.usuario_icon),
        };

        PatientsTodayAdapter patientsAdapter = new PatientsTodayAdapter(this,R.layout.listview_item_patients_today_row, patiensData);
        listViewAppoinmnet.setAdapter(patientsAdapter);

    }



}
