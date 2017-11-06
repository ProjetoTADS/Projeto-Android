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
    String[] data;

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

        resultado = db.insert(Model.TABELA, null, valores);

        if (resultado == -1) {
            return " Erro ao inserir registro ";
        } else {
            return " Usuário inserido com sucesso! ";
        }
    }

    public void listAll() {
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios", null);

        int indiceColuna = cursor.getColumnIndex("NOME");
        cursor.moveToFirst();
        while (cursor != null) {
            Log.i("NOME", cursor.getString(indiceColuna));
            cursor.moveToNext();
        }
    }

}