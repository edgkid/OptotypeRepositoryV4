package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {

    Button logOut;
    ImageView imageUser;
   // TextView userName;

    ListView listViewMenu;
    Context contextActivity;

    String [] menuDoctor;
    //String [] menuPatients = new String []{"PA A", "PA B", "PA C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        contextActivity = this;
        logOut = (Button) findViewById(R.id.buttonLogout);
        imageUser = (ImageView) findViewById(R.id.imageViewLoginUser);
        //userName = (TextView) findViewById(R.id.textViewLoginUser);
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

       /* if (preferences.getString("roll", "defaultroll").equals("Doctor")){
            ArrayAdapter<String> adapterMenuDoctor = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, menuDoctor);
            listViewMenu.setAdapter(adapterMenuDoctor);
        }else if(preferences.getString("roll", "defaultroll").equals("Paciente Infantil")){
            //ArrayAdapter<String> adapterMenuPatient = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, menuPatients);
            //listViewMenu.setAdapter(adapterMenuPatient);
            loadListPatientsToday();
        }*/

        // linea temporal para trabajar en la oficina

        //loadListPatientsToday();
        loadListMenuDoctor();

    }

    /**
     * This method fill a Listview with patients in witing room
     */
    public void loadListPatientsToday (){

          int countValue = 0;
        //Listado de pacientes genericos para trabajar en la oficina
        PatientsToday patiensData[] = new PatientsToday[]{
                new PatientsToday("Edgar Rafel Landaeta Malave","4",R.drawable.usuario_icon),
                new PatientsToday("Gabriel Andres Landaeta Eljuri","4",R.drawable.usuario_icon),
                new PatientsToday("Juan Francisco Landaeta Eljuri","4",R.drawable.usuario_icon),
        };

        PatientsTodayAdapter patientsAdapter = new PatientsTodayAdapter(this,R.layout.listview_item_patients_today_row, patiensData);
        listViewMenu.setAdapter(patientsAdapter);
        ///////////////////////////////////////////// - Bloque a borar

        //Listado de pacieste desde el servicio web
       /* RequestPatient reuquestPatient = new RequestPatient("patients", this);
        reuquestPatient.findPatientsToDay();

        PatientsToday patientsData[] = new PatientsToday[reuquestPatient.CountPatinetsToday()];
        PatientsToday patients[] = reuquestPatient.TakePatientsToday();
        while (countValue < reuquestPatient.CountPatinetsToday() ){
            patientsData[countValue] = new PatientsToday(patients[countValue].getName(),patients[countValue].getYearsOld(),R.drawable.usuario_icon);
            countValue ++;
        }

        PatientsTodayAdapter patientsAdapter = new PatientsTodayAdapter(this,R.layout.listview_item_patients_today_row, patientsData);
        listViewMenu.setAdapter(patientsAdapter);*/

        callInteractionActivityByPatient ();

    }

    public void loadListMenuDoctor(){

        menuDoctor = new String []{ "Nueva Consulta",
                                    "Modificar Consulta",
                                    "Eliminar Consulta",
                                    "Consulta del Día",
                                    "Nuevo Paciente"
        };

        ArrayAdapter<String> adapterMenuDoctor = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, menuDoctor);
        listViewMenu.setAdapter(adapterMenuDoctor);

        callActivitiesByDoctor();

    }

    public void callInteractionActivityByPatient (){

        //final PatientsToday patient = new PatientsToday();
        final Intent interactionActivity = new Intent(this, InteractionActivity.class);

        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView textName = (TextView)view.findViewById(R.id.namePatientToday);
                TextView textyears= (TextView)view.findViewById(R.id.yearsOldPatientToday);
                ImageView photo = (ImageView)findViewById(R.id.photoPatientToday);
                interactionActivity.putExtra("Patient", textName.getText().toString());
                interactionActivity.putExtra("YearsOld", textyears.getText().toString());
                interactionActivity.putExtra("pohoto",textyears.getId());
                startActivity(interactionActivity);
            }
        });

    }


    public void callActivitiesByDoctor (){

        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newActivity = null;
                switch (position){

                    case 0:
                        Toast.makeText(contextActivity,"Nueva Consulta",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(contextActivity,"Modificar Consulta",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        newActivity = new Intent(contextActivity, DeleteAppoinmentActivity.class);
                        break;
                    case 3:
                        newActivity = new Intent(contextActivity, AppoinmentActivity.class);
                        break;
                    case 4:
                        Toast.makeText(contextActivity,"Nuevo Paciente",Toast.LENGTH_SHORT).show();
                        break;
                }
                startActivity(newActivity);
            }
        });


    }


}
