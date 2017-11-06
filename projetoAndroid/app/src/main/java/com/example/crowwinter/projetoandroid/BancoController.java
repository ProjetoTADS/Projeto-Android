package com.example.crowwinter.projetoandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.midi.MidiOutputPort;
import android.util.Log;
import android.view.Display;

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

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos = {"_id","nome","email","telefone","nascimento"} ;
        db = banco.getReadableDatabase();
        cursor = db.query(true,"usuarios",campos , null, null, null, null, null, null);

        cursor.moveToFirst();
        if(cursor!=null) {
            cursor.moveToNext();
        }

        db.close();
        return cursor;
    }
}
