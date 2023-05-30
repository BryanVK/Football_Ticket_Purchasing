package com.bryan.uts_mcs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailNewsActivity extends AppCompatActivity {

    TextView tvTitle, tvDesc, tvDate;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        tvTitle = findViewById(R.id.headline);
        tvDesc = findViewById(R.id.desc);
        tvDate = findViewById(R.id.date);
        image = findViewById(R.id.image);

        News news = getIntent().getParcelableExtra("NEWS");
        tvTitle.setText(news.getHeadline());
        tvDesc.setText(news.getDesc());
        tvDate.setText(news.getDate());
        image.setImageResource(news.getPhoto());
    }
}