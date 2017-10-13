package com.example.crowwinter.projetoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Cadastrar_novo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_novo);
    }

    public void onClickVoltar (View v){
        Intent i = new Intent(this, Menu_Principal.class);
        startActivity(i);

    }
}
