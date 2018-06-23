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

    String newString,stringTeste,stringAc,stringEnd,stringHo;
    TextView txtV,edtT,ed_ac,ed_end,ed_ho;


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
        stringAc = dbAc.getAco(newString);
        stringEnd = dbAc.getEnd(newString);
        stringHo = dbAc.getHor(newString);

        ed_end = findViewById(R.id.endereco_et);
        ed_end.setText(stringEnd);
        ed_ho = findViewById(R.id.horatio_et);
        ed_ho.setText(stringHo);
        ed_ac = findViewById(R.id.acomodacoes_et);
        ed_ac.setText(stringAc);
        edtT = findViewById(R.id.info_et);
        edtT.setText(stringTeste);

        dbAc.close();

    }


}
