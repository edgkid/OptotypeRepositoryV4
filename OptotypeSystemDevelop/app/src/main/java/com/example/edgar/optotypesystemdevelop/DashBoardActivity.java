package com.example.edgar.optotypesystemdevelop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        contextActivity = this;
        logOut = (Button) findViewById(R.id.buttonLogout);
        imageUser = (ImageView) findViewById(R.id.imageViewLoginUser);
        userName = (TextView) findViewById(R.id.textViewLoginUser);
        logOut.setOnClickListener((View.OnClickListener) contextActivity);

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


}
