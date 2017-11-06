package com.example.crowwinter.projetoandroid;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

                if(nomeString.equals("")){
                    Toast.makeText(Cadastrar_novo.this,"Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                }
                else if (emailString.equals("")){
                    Toast.makeText(Cadastrar_novo.this,"Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                }
                else if (telefoneString.equals("")){
                    Toast.makeText(Cadastrar_novo.this,"Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                }
                else if (nascimentoString.equals("")){
                    Toast.makeText(Cadastrar_novo.this,"Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                }




                resultado = crud.insereUsuario(nomeString,emailString,telefoneString, nascimentoString);

               Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

            }
        });


    }

    public void onClickVoltar (View v){
        Intent i = new Intent(this, Menu_Principal.class);
        startActivity(i);

    }
}
