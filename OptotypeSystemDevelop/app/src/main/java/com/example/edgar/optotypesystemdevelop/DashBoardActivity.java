package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {

    Button logOut;
    ImageView imageUser;
    TextView userName;

    ListView listViewMenu;
    Context contextActivity;

    String [] menuDoctor = new String []{"Asociar Test", "Opción B", "Opción C" };
    //String [] menuPatients = new String []{"PA A", "PA B", "PA C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        contextActivity = this;
        logOut = (Button) findViewById(R.id.buttonLogout);
        imageUser = (ImageView) findViewById(R.id.imageViewLoginUser);
        userName = (TextView) findViewById(R.id.textViewLoginUser);
        logOut.setOnClickListener((View.OnClickListener) contextActivity);

        listViewMenu = (ListView) findViewById(R.id.listViewDashBoardMenu);
        loadMenu();

    }

    @Override
    public void onClick(View v) {

        cleanPreferencesLogin();

        Intent loginActivity = new Intent(this, LoginActivity.class);
        startActivity(loginActivity);
    }

    /**
     *This method clean the shared preference to user with login
     */
    public void cleanPreferencesLogin (){

        SharedPreferences loginPreferences = getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor preferencesEditor = loginPreferences.edit();
        preferencesEditor.clear();
        preferencesEditor.commit();

    }

    /**
     * This method fill a Listview with option for user or list the patients
     */
    public void loadMenu(){

        // Comentario para trabajar local desde la oficina
        SharedPreferences preferences = getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE);

        if (preferences.getString("roll", "defaultroll").equals("Doctor")){
            ArrayAdapter<String> adapterMenuDoctor = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, menuDoctor);
            listViewMenu.setAdapter(adapterMenuDoctor);
        }else if(preferences.getString("roll", "defaultroll").equals("Paciente Infantil")){
            /*ArrayAdapter<String> adapterMenuPatient = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, menuPatients);
            listViewMenu.setAdapter(adapterMenuPatient);*/
            loadListPatientsToday();
        }

        // linea temporal para trabajar en la oficina
        //loadListPatientsToday();

    }

    /**
     * This method fill a Listview with patients in witing room
     */
    public void loadListPatientsToday (){

        //Listado de pacientes genericos para trabajar en la oficina
        PatientsToday patiensData[] = new PatientsToday[]{
                new PatientsToday("edgar","4",R.drawable.usuario_icon),
                new PatientsToday("Gabriel","4",R.drawable.usuario_icon),
                new PatientsToday("Juan","4",R.drawable.usuario_icon),
        };
        ///////////////////////////////////////////// - Bloque a borar

        PatientsTodayAdapter patientsAdapter = new PatientsTodayAdapter(this,R.layout.listview_item_patients_today_row, patiensData);
        listViewMenu.setAdapter(patientsAdapter);

        //Listado de pacieste desde el servicio web
        /*RequestPatient reuquestPatient = new RequestPatient("patients", this);
        reuquestPatient.findPatientsToDay();*/

        //callInteractionActivityByPatient ();

    }


}
