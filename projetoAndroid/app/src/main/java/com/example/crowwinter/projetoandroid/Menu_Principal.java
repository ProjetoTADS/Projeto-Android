package com.example.crowwinter.projetoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu_Principal extends AppCompatActivity {

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
