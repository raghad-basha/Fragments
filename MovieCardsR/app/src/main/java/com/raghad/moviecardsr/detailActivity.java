package com.raghad.moviecardsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class detailActivity extends AppCompatActivity {
    private ImageView poster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        poster = (ImageView)findViewById(R.id.imageView);


        Bundle bundle = getIntent().getExtras();

        int theImg = bundle.getInt("photo",0);
        poster.setImageResource(theImg);
    }
}
