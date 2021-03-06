package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextUserName;
    EditText    editTextPaswword;
    Button buttonLogin;
    ImageView imageViewIcon;
    Context contextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        contextActivity = this;

        editTextUserName = (EditText) findViewById(R.id.editTextUserNameLogin);
        editTextPaswword = (EditText) findViewById(R.id.editTextViewPassWord);
        imageViewIcon   = (ImageView) findViewById(R.id.imageViewIconEye);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener((View.OnClickListener) contextActivity);

        initializeApp();
        verifyPreferencesLogin();

    }

    @Override
    public void onClick(View v) {

        //Para trabajar con Servidor
        String resourceUser = "users/"+editTextUserName.getText().toString() + "," + editTextPaswword.getText().toString();
        RequestUser requestUser = new RequestUser(resourceUser, this);

        if (requestUser.findUserOnSystem()){
            callNewActivity();
        }else{
            Toast.makeText(this, "Problemas de conexion, imposible ingresar", Toast.LENGTH_SHORT).show();
        }

        // Para trabajar Local
        //callNewActivity();

    }

    public void callNewActivity (){

        Intent dashBoardActivity = new Intent(this, DashBoardActivity.class);
        startActivity(dashBoardActivity);

    }

    /**
     *This method verify if sharedpreferences login file contend the data
     */
    public void verifyPreferencesLogin (){

        String user = "";
        String password = "";

        SharedPreferences loginPreferences = this.getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE);

        user =  loginPreferences.getString("user", "defaultUser");
        password = loginPreferences.getString("password", "defaultUser");

        if (!user.equals("defaultUser") && !password.equals("defaultUser")){
            callNewActivity();
        }

    }

    public void initializeApp (){
        OptoTypeDbAppInitialize newTables = new OptoTypeDbAppInitialize(contextActivity);

        newTables.findOrCreteTablePatients();
        newTables.findOrCreateTableOptotypes();

    }
}
