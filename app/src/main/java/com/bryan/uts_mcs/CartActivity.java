package com.bryan.uts_mcs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.bryan.uts_mcs.Database.HelperDatabase;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";

    public static final String Email = "emailKey";

    HelperDatabase databaseHelper;
    RecyclerView recyclerView;
    TicketAdapter adapter;
    ArrayList<String> match, date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        databaseHelper = new HelperDatabase(CartActivity.this);
        match = new ArrayList<>();
        date = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new TicketAdapter(this, match, date);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();



    }

    private void displayData() {
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        String email = sharedpreferences.getString(Email, "");
        Cursor cursor = databaseHelper.readAllData(email);
        if (cursor.getCount()==0){
            Toast.makeText(this, "No Entry Exist", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
//                if(cursor.getString(1) == "rahmat@gmail.com"){
                    match.add(cursor.getString(2));
                    date.add(cursor.getString(0));
//                }

            }
        }
    }


}