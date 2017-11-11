package com.example.crowwinter.projetoandroid;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Menu_Principal extends Activity {

    Button btnCad,btnList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__principal);
        btnCad = (Button) findViewById(R.id.btnCadastro);
        btnList = (Button) findViewById(R.id.btnListar);
    }

    public void onClick(View v){
        finish();
        btnCad.setBackgroundColor(Color.WHITE);
        btnCad.setTextColor(Color.rgb(03,24,45));
        Intent intent = new Intent(this,Cadastrar_novo.class);
        startActivity(intent);


    }
    public void onClick2(View v){
        finish();
        btnList.setBackgroundColor(Color.WHITE);
        btnList.setTextColor(Color.rgb(03,24,45));
        Intent intent = new Intent(this,Listar_todos.class);
        startActivity(intent);

    }


}
