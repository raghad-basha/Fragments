package com.raghad.movieshow;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<MovieAlbum> arrayList = new ArrayList<>();
    int [] im_id={R.drawable.reva,R.drawable.reva2,R.drawable.sarab,R.drawable.kh,R.drawable.suha
            ,R.drawable.hana,R.drawable.fat,R.drawable.oh,R.drawable.khokh};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // link the recycler view in main.xml with main,java
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        for (int id : im_id){

            arrayList.add(new MovieAlbum(id));

        }
        adapter= new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter); }



    public void click(View view) {
        ImageView image = (ImageView)findViewById(R.id.album); }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

}