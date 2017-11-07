package com.example.crowwinter.projetoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Dados_do_usuario extends AppCompatActivity {


    EditText txtnome;
    EditText txtemail;
    EditText txttelefone;
    EditText txtdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_do_usuario);

        txtnome = (EditText)findViewById(R.id.txtNome);
        txtemail = (EditText)findViewById(R.id.txtEmail);
        txttelefone = (EditText)findViewById(R.id.txtTelefone);
        txtdata = (EditText)findViewById(R.id.txtData);

        Bundle extras = getIntent().getExtras();
        String nome = extras.getString("nome");
        String email = extras.getString("email");
        String telefone = extras.getString("telefone");
        String data = extras.getString("data");

        txtnome.setText(nome);
        txtemail.setText(email);
        txttelefone.setText(telefone);
        txtdata.setText(data);
    }


    public void onClickListar (View v){
        finish();
        Intent i = new Intent(this, Listar_todos.class);
        startActivity(i);

    }
}
