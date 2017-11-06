package com.example.crowwinter.projetoandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by eduardo on 15/10/17.
 */

public class BancoController {
    private SQLiteDatabase db;
    private Model banco;

    public BancoController(Context context){
        banco = new Model(context);
    }

    public String insereUsuario(String nome, String email, String telefone, String nascimento){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();

        valores = new ContentValues();

        valores.put(Model.NOME, nome);
        valores.put(Model.EMAIL, email);
        valores.put(Model.TELEFONE, telefone);
        valores.put(Model.NASCIMENTO, nascimento);

        resultado = db.insert(Model.TABELA, null, valores);

        db.close();

        if (resultado == -1){
            return "Erro ao inserir registro";
        }
        else{
            return "Usuário inserido com sucesso!";
        }
    }


}
