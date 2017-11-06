package com.example.crowwinter.projetoandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.midi.MidiOutputPort;
import android.util.Log;
import android.view.Display;

import static android.content.ContentValues.TAG;

/**
 * Created by eduardo on 15/10/17.
 */

public class BancoController {
    private SQLiteDatabase db;
    private Model banco;
    long resultado;
    String[] place;

    public BancoController(Context context) {
        banco = new Model(context);
    }


    public String insereUsuario(String nome, String email, String telefone, String nascimento) {
        ContentValues valores;

        db = banco.getWritableDatabase();

        valores = new ContentValues();

        valores.put(Model.NOME, nome);
        valores.put(Model.EMAIL, email);
        valores.put(Model.TELEFONE, telefone);
        valores.put(Model.NASCIMENTO, nascimento);

        resultado = db.insertOrThrow(Model.TABELA, "null", valores);


        db.close();

        if (resultado == -1) {
            return "Usario nao cadastrado";
        } else {
            return "Usuario cadastrado";
        }
    }

    public String[] carregaDados(){
        Cursor cursor;
        String[] campos = {"nome"} ;
        db = banco.getReadableDatabase();
        cursor = db.query(true,"usuarios",campos , null, null, null, null, null, null);


        String array[] = new String[cursor.getCount()];
        int i=0;
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            array[i]=cursor.getString(0);
            i++;
            cursor.moveToNext();
        }
        cursor.close();
        db.close();

        return array;
    }
}
