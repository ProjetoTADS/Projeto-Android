package com.example.crowwinter.projetoandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

        resultado = db.insert(Model.TABELA, "null", valores);


        db.close();

        if (resultado == -1) {
            return String.valueOf(resultado);
        } else {
            return "Usuario cadastrado";
        }
    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {Model.NOME,Model.EMAIL,Model.TELEFONE,Model.NASCIMENTO};
        db = banco.getReadableDatabase();
        cursor = db.query(Model.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
