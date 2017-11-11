package com.example.crowwinter.projetoandroid;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar_novo extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText telefone;
    private EditText nascimento;
    private Button btnCadastrar;
    private Button btnVoltar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_novo);

        btnCadastrar = (Button) findViewById(R.id.btn_cadastrar);
        btnVoltar = (Button) findViewById(R.id.btn_voltar);


        btnCadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                btnCadastrar.setBackgroundColor(Color.WHITE);
                btnCadastrar.setTextColor(Color.rgb(03,24,45));
                BancoController crud = new BancoController(getBaseContext());
                String resultado;

                nome = (EditText) findViewById(R.id.txtNome);
                email = (EditText) findViewById(R.id.txtEmail);
                telefone = (EditText) findViewById(R.id.txtTelefone);
                nascimento = (EditText) findViewById(R.id.txtNascimento);

                String nomeString = nome.getText().toString();
                String emailString = email.getText().toString();
                String telefoneString = telefone.getText().toString();
                String nascimentoString = nascimento.getText().toString();

                if(nomeString.equals("") || emailString.equals("") || telefoneString.equals("") || nascimentoString.equals("")) {
                    if (nomeString.equals("")) {
                        Toast.makeText(Cadastrar_novo.this, "Preencha o campo nome", Toast.LENGTH_LONG).show();
                    }
                    if (emailString.equals("")) {
                        Toast.makeText(Cadastrar_novo.this, "Preencha o campo email", Toast.LENGTH_LONG).show();
                    }
                    if (telefoneString.equals("")) {
                        Toast.makeText(Cadastrar_novo.this, "Preencha o campo telefone", Toast.LENGTH_LONG).show();
                    }
                    if (nascimentoString.equals("")) {
                        Toast.makeText(Cadastrar_novo.this, "Preencha o campo nascimento", Toast.LENGTH_LONG).show();
                    }
                }
                else {

                    resultado = crud.insereUsuario(nomeString, emailString, telefoneString, nascimentoString);

                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                    finish();
                    Intent intent = new Intent(getApplicationContext(), Listar_todos.class);
                    startActivity(intent);
                }

            }
        });

    }
    public void onClickVoltar (View v){
        finish();
        btnVoltar.setBackgroundColor(Color.WHITE);
        btnVoltar.setTextColor(Color.rgb(03,24,45));
        Intent i = new Intent(this, Menu_Principal.class);
        startActivity(i);

    }
}
