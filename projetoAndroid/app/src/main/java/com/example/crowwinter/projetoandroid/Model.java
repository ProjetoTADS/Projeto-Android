package com.example.crowwinter.projetoandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eduardo on 15/10/17.
 */

public class Model extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "usuarios";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String TELEFONE = "telefone";
    public static final String NASCIMENTO = "nascimento";
    private static final int VERSAO = 1;

    //CONSTRUTOR
    public Model(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

<<<<<<< HEAD
        String sql = "CREATE TABLE usuarios("
                + ID + " integer primary key autoincrement, "
=======
        String sql = " CREATE TABLE IF NOT EXISTS " +TABELA+ "("
                + ID + " integer primary key autoincrement,"
>>>>>>> aeb6b87049a44847e5cf51ec8d0641c59839e556
                + NOME + " text,"
                + EMAIL + " text,"
                + TELEFONE + " text,"
                + NASCIMENTO + " text"
                +")";
        db.execSQL(sql);
    }

    @Override
<<<<<<< HEAD
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
=======
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
>>>>>>> aeb6b87049a44847e5cf51ec8d0641c59839e556
        db.execSQL(" DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
