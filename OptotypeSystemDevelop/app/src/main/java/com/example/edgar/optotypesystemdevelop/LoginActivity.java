package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.content.Intent;
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
        Log.d("","Edgar ");
        System.out.println("Edgar sys");

    }

    @Override
    public void onClick(View v) {

        Log.d("","coño de la madre nojoda ");
        System.out.println("COño de la madre");
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
}
