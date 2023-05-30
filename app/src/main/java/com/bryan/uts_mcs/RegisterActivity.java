package com.bryan.uts_mcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bryan.uts_mcs.Database.HelperDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, emailIn, password;
    Button btnRegis;
    TextView btnLogin;
    HelperDatabase DB;
    Integer count = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegis = findViewById(R.id.btn_register);
        btnRegis.setOnClickListener(this);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        username = findViewById(R.id.edt_username);
        emailIn = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        DB = new HelperDatabase(this);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 1;
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String email = emailIn.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(email))
                    Toast.makeText(RegisterActivity.this, "All field Required", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuser = DB.checkEmail(email);
                    if (checkuser==false){
                        Boolean insert = DB.insertData(user, email, pass, null);
                        if(insert==true){
                            Toast.makeText(RegisterActivity.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Registered Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "User already Exist", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            Intent moveIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(moveIntent);

        }
    }

}