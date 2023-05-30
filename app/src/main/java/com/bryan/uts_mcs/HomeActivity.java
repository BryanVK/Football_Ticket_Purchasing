package com.bryan.uts_mcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsAdapter adapter;
    ArrayList<News> objNews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        objNews.addAll(getListNews());
        showRecyclerList();

    }



    public ArrayList<News> getListNews(){
        String[] title = getResources().getStringArray(R.array.data_headline);
        String[] desc = getResources().getStringArray(R.array.data_desc);
        String[] date = getResources().getStringArray(R.array.data_date);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

        ArrayList<News> listNews = new ArrayList<>();

        for(int i = 0; i<title.length; i++){
            News news = new News();
            news.setHeadline(title[i]);
            news.setDesc(desc[i]);
            news.setDate(date[i]);
            news.setPhoto(dataPhoto.getResourceId(i,-1));
            listNews.add(news);
        }
        return listNews;
    }

    private void showRecyclerList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter newsAdapter = new NewsAdapter(objNews);
        recyclerView.setAdapter(newsAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.profile){
            Intent moveIntent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(moveIntent);
        } else if (item.getItemId() == R.id.cart) {
            Intent moveIntent2 = new Intent(HomeActivity.this, CartActivity.class);
            startActivity(moveIntent2);
        } else if (item.getItemId() == R.id.schedule) {
            Intent moveIntent3 = new Intent(HomeActivity.this, ScheduleActivity.class);
            startActivity(moveIntent3);
        }
        return super.onOptionsItemSelected(item);
    }
}