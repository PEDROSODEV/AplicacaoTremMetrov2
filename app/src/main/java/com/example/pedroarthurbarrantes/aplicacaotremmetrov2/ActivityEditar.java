package com.example.pedroarthurbarrantes.aplicacaotremmetrov2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityEditar extends AppCompatActivity{

    CircleImageView civ_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);


    }

    private void carregarIntent(){

        civ_image = findViewById(R.id.imagem);

        Intent i = getIntent();
        Bundle bd = i.getExtras();
        if (bd != null){
            civ_image = (CircleImageView) bd.get("Imagem");

        }
    }
}
