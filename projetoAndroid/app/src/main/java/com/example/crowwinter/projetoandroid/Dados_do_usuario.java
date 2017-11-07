package com.example.crowwinter.projetoandroid;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;


public class Dados_do_usuario extends AppCompatActivity {

    private SQLiteDatabase db;
    private EditText txtnome;
    private EditText txtemail;
    private EditText txttelefone;
    private EditText txtdata;
    private Button btnAtualiza;



    int id;
    String nome,email,telefone,data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_do_usuario);
        db = openOrCreateDatabase(Model.NOME_BANCO, MODE_PRIVATE, null);

        txtnome = (EditText)findViewById(R.id.txtNome);
        txtemail = (EditText)findViewById(R.id.txtEmail);
        txttelefone = (EditText)findViewById(R.id.txtTelefone);
        txtdata = (EditText)findViewById(R.id.txtData);
        btnAtualiza = (Button)findViewById(R.id.btnAlterar);

        Bundle extras = getIntent().getExtras();
        id = extras.getInt("id");
        nome = extras.getString("nome");
        email = extras.getString("email");
        telefone = extras.getString("telefone");
        data = extras.getString("data");

        txtnome.setText(nome);
        txtemail.setText(email);
        txttelefone.setText(telefone);
        txtdata.setText(data);

        btnAtualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtnome.getText().toString();
                String email = txtemail.getText().toString();
                String telefone = txttelefone.getText().toString();
                String data = txtdata.getText().toString();

                ContentValues valores;
                String WHERE;

//                db = banco.getWritableDatabase();

                WHERE = Model.ID+"="+id;

                valores = new ContentValues();
                valores.put(Model.NOME,name);
                valores.put(Model.EMAIL,email);
                valores.put(Model.TELEFONE,telefone);
                valores.put(Model.NASCIMENTO,data);

                db.update(Model.TABELA,valores,WHERE,null);
                Toast.makeText(getApplicationContext(),"Dados atualizados com sucesso!",Toast.LENGTH_LONG).show();
                finish();
                Intent i = new Intent(getApplicationContext(),Listar_todos.class);
                startActivity(i);
            }
        });

    }


    public void onClickListar (View v){
        finish();
        Intent i = new Intent(this, Listar_todos.class);
        startActivity(i);

    }
}
