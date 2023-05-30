 package com.bryan.uts_mcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        Button btnRegis = findViewById(R.id.btn_register);
        btnRegis.setOnClickListener(this);

    }

     @Override
     public void onClick(View v) {
         if (v.getId() == R.id.btn_login){
             Intent MoveIntent = new Intent(MainActivity.this, LoginActivity.class);
             startActivity(MoveIntent);
         }else if(v.getId() == R.id.btn_register){
             Intent MoveIntent2 = new Intent(MainActivity.this, RegisterActivity.class);
             startActivity(MoveIntent2);
         }
     }

 }