package com.example.pedroarthurbarrantes.aplicacaotremmetrov2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pedroarthurbarrantes.aplicacaotremmetrov2.Database.DatabaseAccess;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityEditar extends AppCompatActivity{

    String newString,stringTeste;
    TextView txtV;
    TextView edtT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        Bundle extras = getIntent().getExtras();
        if (!extras.isEmpty()){
            newString = extras.getString("IMPORTANT_VALUE");
        }
        txtV = findViewById(R.id.nomeImage);
        txtV.setText(newString);

        DatabaseAccess dbAc = DatabaseAccess.getInstance(getApplicationContext());
        dbAc.open();

        stringTeste = dbAc.getInfo(newString);

        edtT = findViewById(R.id.info_et);
        edtT.setText(stringTeste);

        dbAc.close();

    }


}
