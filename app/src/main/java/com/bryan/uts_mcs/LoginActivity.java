package com.bryan.uts_mcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bryan.uts_mcs.Database.HelperDatabase;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sharedpreferences;
    EditText emailIn, password;
    Button btnRegis;
    TextView btnLogin;
    HelperDatabase DB;



    public static final String mypreference = "mypref";
    public static final String mypreference1 = "mypref22";
    public static final String Password = "passKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        emailIn = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        DB = new HelperDatabase(this);



        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);


        if (sharedpreferences.contains(Password)) {
            password.setText(sharedpreferences.getString(Password, ""));
        }
        if (sharedpreferences.contains(Email)) {
            emailIn.setText(sharedpreferences.getString(Email, ""));

        }



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = emailIn.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(pass) || TextUtils.isEmpty(email))
                    Toast.makeText(LoginActivity.this, "All field Required", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkEmailPassword(email, pass);
                    if (checkuserpass==true){

                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class );
                        startActivity(intent);
                        Save(v);

                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void Save(View view) {
        String n = password.getText().toString();
        String e = emailIn.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Password, n);
        editor.putString(Email, e);
        editor.apply();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register){
            Intent moveIntent2 = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(moveIntent2);
        }
    }
}