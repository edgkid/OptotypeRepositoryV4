package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class DeleteAppoinmentActivity extends AppCompatActivity {


    Button logOut;
    ImageView imageUser;
    // TextView userName;

    ListView listViewAppoinment;
    Context contextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_appoinment);

        contextActivity = this;
        logOut = (Button) findViewById(R.id.buttonLogout);
        imageUser = (ImageView) findViewById(R.id.imageViewLoginUser);
        listViewAppoinment = (ListView) findViewById(R.id.listViewAppoinmentForDelete);

        loadAppoinment();

    }

    public void loadAppoinment (){

        // se debe modificar para consumir información del servidor
        ListActionOnPatient patientsData[] = new ListActionOnPatient[]{
                new ListActionOnPatient(R.drawable.usuario_icon,"Edgar Rafel Landaeta Malave", R.drawable.icon_garbage),
                new ListActionOnPatient(R.drawable.usuario_icon,"Gabriel Andres Landaeta Eljuri",R.drawable.icon_garbage),
                new ListActionOnPatient(R.drawable.usuario_icon,"Juan Francisco Landaeta Eljuri",R.drawable.icon_garbage),
                new ListActionOnPatient(R.drawable.usuario_icon,"Adira Yadira Quintero Sanchez",R.drawable.icon_garbage),
                new ListActionOnPatient(R.drawable.usuario_icon,"Kimberly Carolina Iriearte Perozo",R.drawable.icon_garbage),
                new ListActionOnPatient(R.drawable.usuario_icon,"Victor Alejandro Landaeta Landaeta",R.drawable.icon_garbage),
                new ListActionOnPatient(R.drawable.usuario_icon,"Abrahan Rafel Castillo Pernia",R.drawable.icon_garbage),
                new ListActionOnPatient(R.drawable.usuario_icon,"Jesus Gabriel Moreno Campo",R.drawable.icon_garbage),
                new ListActionOnPatient(R.drawable.usuario_icon,"Victoria Coromoto Malave Campo",R.drawable.icon_garbage),
                new ListActionOnPatient(R.drawable.usuario_icon,"Jessica Maria Guzman Palacio",R.drawable.icon_garbage),
                new ListActionOnPatient(R.drawable.usuario_icon,"Gabriela Maria Gimenes Arroyo",R.drawable.icon_garbage),
                new ListActionOnPatient(R.drawable.usuario_icon,"Cesar Alejandro Galindo Guerra",R.drawable.icon_garbage)
        };

        ListActionOnPatientAdapter actionsAdapter = new ListActionOnPatientAdapter(this,R.layout.list_action_on_patient_row, patientsData);
        listViewAppoinment.setAdapter(actionsAdapter);

    }


}
