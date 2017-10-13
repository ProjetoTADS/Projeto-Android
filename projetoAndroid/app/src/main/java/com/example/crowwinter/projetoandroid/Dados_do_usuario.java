package com.example.crowwinter.projetoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dados_do_usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_do_usuario);
    }
    public void onClickListar (View v){
        Intent i = new Intent(this, Listar_todos.class);
        startActivity(i);

    }
}
