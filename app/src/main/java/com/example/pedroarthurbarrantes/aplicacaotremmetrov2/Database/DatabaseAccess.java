package com.example.pedroarthurbarrantes.aplicacaotremmetrov2.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //construtor privado

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //retornando a instancia do banco

    public static DatabaseAccess getInstance(Context context){
        if (instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //para abrir a conexao

    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    //para fechar a conexao

    public void close(){
        this.db.close();
    }

    public String getNome(String name){
        c=db.rawQuery("SELECT nome from tb_rV where nome='" + name + "'",new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String address = c.getString(0);
            buffer.append(""+address);
        }
        return buffer.toString();
    }



}
