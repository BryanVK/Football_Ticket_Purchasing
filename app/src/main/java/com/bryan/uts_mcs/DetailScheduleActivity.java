package com.bryan.uts_mcs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bryan.uts_mcs.Database.HelperDatabase;

import java.util.ArrayList;

public class DetailScheduleActivity extends AppCompatActivity implements View.OnClickListener {


    TextView tvTitle, tvDate;
    ImageView image;
    Button buy;

    String match;
    HelperDatabase DB;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";

    public static final String Email = "emailKey";

    ArrayList<Schedule> scheduleArrayList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_schedule);

        tvTitle = findViewById(R.id.Match);
        tvDate = findViewById(R.id.Date);
        image = findViewById(R.id.image);
        buy = findViewById(R.id.buy);


        Schedule schedule = getIntent().getParcelableExtra("SCHEDULE");
        match = schedule.getMatch();
        tvTitle.setText(schedule.getMatch());
        tvDate.setText(schedule.getDate());
        image.setImageResource(schedule.getImage());

        Button btnBuy = findViewById(R.id.buy);
        btnBuy.setOnClickListener(this);


    }
    private static int inc = 0;

    private static long getId(){

        long id = Long.parseLong(String.valueOf(System.currentTimeMillis())
                .substring(1,10)
                .concat(String.valueOf(inc)));
        inc = (inc+1)%10;
        return id;
    }

    @Override
    public void onClick(View v) {

        String email;
        DB = new HelperDatabase(this);
        if (v.getId() == R.id.buy){

            sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
            email = sharedpreferences.getString(Email, "");
            Long ticketId = getId();
            Boolean cek = DB.insertTicket(ticketId, email, match);

            if (cek == true){
                Toast.makeText(DetailScheduleActivity.this, "Payment Success", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(DetailScheduleActivity.this, "Failed tickets have been purchased ", Toast.LENGTH_SHORT).show();
            }


//            Intent moveIntent = new Intent(DetailScheduleActivity.this, CartActivity.class);
//            startActivity(moveIntent);
        }
    }

}