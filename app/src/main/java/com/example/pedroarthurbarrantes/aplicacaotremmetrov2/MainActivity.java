package com.example.pedroarthurbarrantes.aplicacaotremmetrov2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrl = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageBitmap();

    }

    private void initImageBitmap(){
        mImageUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTj_HJqK0q03JIykdgsFcobtQeJbLrAGt5lb3WeX1NLqNOhphWT");
        mNames.add("Estação de São Caetano do Sul");

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames,mImageUrl,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}