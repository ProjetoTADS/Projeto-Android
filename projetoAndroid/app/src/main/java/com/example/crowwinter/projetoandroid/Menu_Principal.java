package com.example.crowwinter.projetoandroid;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Menu_Principal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__principal);
    }

    public void onClick(View v){
        Intent intent = new Intent(this,Cadastrar_novo.class);
        startActivity(intent);


    }
    public void onClick2(View v){
        Intent intent = new Intent(this,Listar_todos.class);
        startActivity(intent);


    }


}
