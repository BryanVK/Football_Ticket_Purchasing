package com.bryan.uts_mcs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ScheduleAdapter adapter;
    ArrayList<Schedule> objNews = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        objNews.addAll(getListSchedule());
        showRecyclerList();
    }


    public ArrayList<Schedule> getListSchedule(){
        String[] match = getResources().getStringArray(R.array.data_match);
        String[] date = getResources().getStringArray(R.array.data_schedule);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo_match);

        ArrayList<Schedule> listSchedule = new ArrayList<>();

        for(int i = 0; i<match.length; i++){
            Schedule schedule = new Schedule();
            schedule.setMatch(match[i]);
            schedule.setDate(date[i]);
            schedule.setImage(dataPhoto.getResourceId(i,-1));
            listSchedule.add(schedule);
        }
        return listSchedule;
    }

    private void showRecyclerList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(objNews);
        recyclerView.setAdapter(scheduleAdapter);

    }

}