package com.example.crowwinter.projetoandroid;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;




public class Listar_todos extends AppCompatActivity {
    private ListView listaitens;
    private AlertDialog.Builder dialog;
    private String[] itens;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_todos);

        BancoController crud = new BancoController(getApplicationContext());

        itens = crud.carregaDados();

        bd = openOrCreateDatabase(Model.NOME_BANCO, MODE_PRIVATE, null);

        listaitens = (ListView) findViewById(R.id.listViewID);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        listaitens.setAdapter(adapter);

        listaitens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int codigoPosicao = i;

                final String valorClicado = (String) listaitens.getItemAtPosition(codigoPosicao);



                Toast.makeText(getApplicationContext(),valorClicado,Toast.LENGTH_SHORT).show();
                dialog = new AlertDialog.Builder(Listar_todos.this);
                dialog.setTitle("SELECIONE A AÇÃO QUE DESEJA REALIZAR:");
                dialog.setMessage("VOCÊ PODERÁ EXCLUIR ESTE USUÁRIO OU VER OS DADOS E ALTERÁ=LOS.");
                dialog.setNegativeButton("EXCLUIR USUÁRIO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Listar_todos.this, "Usuários Excluido com sucesso!",Toast.LENGTH_SHORT).show();

                        bd.execSQL("DELETE FROM usuarios WHERE nome = '" + valorClicado + "'");


                        onCreate();
                }
                });
                dialog.setPositiveButton("VER DADOS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Listar_todos.this, "Pressionou o botao Sim",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.create();
                dialog.show();
            }
        });
    }
}
