package com.example.pedroarthurbarrantes.aplicacaotremmetrov2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.example.pedroarthurbarrantes.aplicacaotremmetrov2.Database.DatabaseAccess;

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

        DatabaseAccess dbAc = DatabaseAccess.getInstance(getApplicationContext());
        dbAc.open();

        String n = "Estação de São Caetano do Sul";
        String valor = dbAc.getNome(n);

        mImageUrl.add("http://www.saocaetanodigital.com.br/wp-content/uploads/2014/12/Rodovi%C3%A1ria-e-Esta%C3%A7%C3%A3o-S%C3%A3o-Caetano.jpg");
        mNames.add(dbAc.getNome(valor));

        mImageUrl.add("https://static.panoramio.com.storage.googleapis.com/photos/large/17667128.jpg");
        mNames.add(dbAc.getNome("Estação de Santo André"));

        mImageUrl.add("http://trjs.com.br/images/rodoviaria_joao_setti.jpg");
        mNames.add(dbAc.getNome("Estação de São Bernardo"));

        dbAc.close();

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames,mImageUrl,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
