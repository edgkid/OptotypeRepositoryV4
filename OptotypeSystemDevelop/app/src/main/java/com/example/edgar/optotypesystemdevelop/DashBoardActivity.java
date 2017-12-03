package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    Button update;
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
        update = (Button) findViewById(R.id.buttonUpdate);
        imageUser = (ImageView) findViewById(R.id.imageViewLoginUser);
        //userName = (TextView) findViewById(R.id.textViewLoginUser);
        logOut.setOnClickListener((View.OnClickListener) contextActivity);
        update.setOnClickListener((View.OnClickListener) contextActivity);

        listViewMenu = (ListView) findViewById(R.id.listViewDashBoardMenu);
        loadMenu();

    }

    @Override
    public void onClick(View v) {

        /*cleanPreferencesLogin();

        Intent loginActivity = new Intent(this, LoginActivity.class);
        startActivity(loginActivity);*/

        switch (v.getId()){
            case R.id.buttonLogout:
                //Toast.makeText(contextActivity,"logOut",Toast.LENGTH_SHORT).show();
                logOutDashBoard();
                break;
            case R.id.buttonUpdate:
                //Toast.makeText(contextActivity,"Update",Toast.LENGTH_SHORT).show();
                updateDashBoard();
                break;
        }
    }

    public void logOutDashBoard(){
        cleanPreferencesLogin();

        Intent loginActivity = new Intent(this, LoginActivity.class);
        startActivity(loginActivity);
    }

    public void updateDashBoard(){
        //loadListPatientsToday();
        int countValue = 0;
        RequestPatient reuquestPatient = new RequestPatient("patients", contextActivity);
        PatientsToday patientsData[] = new PatientsToday[reuquestPatient.CountPatinetsToday()];
        Log.d("message: ", Integer.toString(reuquestPatient.CountPatinetsToday()));
        PatientsToday patients[] = reuquestPatient.TakePatientsToday();

        if (patientsData.length == 0)
            Log.d("menssage: ","No hay listado que llenar");
        else
            Log.d("menssage: ","Hay listado que llenar");

        while (countValue < reuquestPatient.CountPatinetsToday() ){
            Log.d("menssage: ","llenando lista");
            patientsData[countValue] = new PatientsToday(patients[countValue].getName(),patients[countValue].getYearsOld(),patients[countValue].getPhoto());
            countValue ++;
        }


        PatientsTodayAdapter patientsAdapter = new PatientsTodayAdapter(this,R.layout.listview_item_patients_today_row, patientsData);
        listViewMenu.setAdapter(patientsAdapter);

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
            loadListMenuDoctor();
        }else if(preferences.getString("roll", "defaultroll").equals("Paciente Infantil")){
            loadListPatientsToday();
        }

        // linea temporal para trabajar en la oficina

        //loadListPatientsToday();
        //loadListMenuDoctor();

    }

    /**
     * This method fill a Listview with patients in witing room
     */
    public void loadListPatientsToday (){

          int countValue = 0;
        //Listado de pacientes genericos para trabajar en la oficina
       /*PatientsToday patiensData[] = new PatientsToday[]{
                new PatientsToday("Edgar Rafel Landaeta Malave","4",R.drawable.usuario_icon),
                new PatientsToday("Gabriel Andres Landaeta Eljuri","4",R.drawable.usuario_icon),
                new PatientsToday("Juan Francisco Landaeta Eljuri","4",R.drawable.usuario_icon),
        };

        PatientsTodayAdapter patientsAdapter = new PatientsTodayAdapter(this,R.layout.listview_item_patients_today_row, patiensData);
        listViewMenu.setAdapter(patientsAdapter);*/
        ///////////////////////////////////////////// - Bloque a borar

        //Listado de pacieste desde el servicio web
        RequestPatient reuquestPatient = new RequestPatient("patients", this);
        reuquestPatient.findPatientsToDay();

        PatientsToday patientsData[] = new PatientsToday[reuquestPatient.CountPatinetsToday()];
        Log.d("message: ", Integer.toString(reuquestPatient.CountPatinetsToday()));
        PatientsToday patients[] = reuquestPatient.TakePatientsToday();

        if (reuquestPatient.CountPatinetsToday() == 0)
            Log.d("menssage: ","No hay listado que llenar");

        while (countValue < reuquestPatient.CountPatinetsToday() ){
            Log.d("menssage: ","llenando lista");
            patientsData[countValue] = new PatientsToday(patients[countValue].getName(),patients[countValue].getYearsOld(),patients[countValue].getPhoto());
            countValue ++;
        }


        PatientsTodayAdapter patientsAdapter = new PatientsTodayAdapter(this,R.layout.listview_item_patients_today_row, patientsData);
        listViewMenu.setAdapter(patientsAdapter);

        callInteractionActivityByPatient ();

    }

    public void loadListMenuDoctor(){

        ItemMenuDoctor itemsData[] = new ItemMenuDoctor[]{
                new ItemMenuDoctor(R.drawable.icon_appoinment, "Nueva Consulta"),
                new ItemMenuDoctor(R.drawable.icon_modify, "Modificar Consulta"),
                new ItemMenuDoctor(R.drawable.icon_garbage, "Eliminar Consulta"),
                new ItemMenuDoctor(R.drawable.icon_calendar, "Consulta del Día"),
                new ItemMenuDoctor(R.drawable.icon_new, "Nuevo Paciente")
        };

        ItemMenuDoctorAdapter itemMenuDoctorAdapter = new ItemMenuDoctorAdapter(this, R.layout.listview_item_doctor_row, itemsData);
        listViewMenu.setAdapter(itemMenuDoctorAdapter);

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
                        newActivity = new Intent(contextActivity, AppoinmentListActivity.class);
                        break;
                    case 1:
                        newActivity = new Intent(contextActivity, ModifyAppoinmentActivity.class);
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
                if (newActivity != null)
                    startActivity(newActivity);
            }
        });


    }


}
