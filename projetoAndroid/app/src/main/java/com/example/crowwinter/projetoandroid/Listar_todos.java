package com.example.crowwinter.projetoandroid;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;



public class Listar_todos extends AppCompatActivity {
    public BancoController bd = new BancoController(getApplicationContext());
    private ListView listaitens;
    private AlertDialog.Builder dialog;
    private String[] itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_todos);

//        listaitens = (ListView) findViewById(R.id.listViewID);


        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {Model.NOME, Model.EMAIL, Model.TELEFONE, Model.NASCIMENTO};
        int[] idViews = new int[] {R.id.txtNome};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_listar_todos,cursor,nomeCampos,idViews, 0);
        listaitens = (ListView)findViewById(R.id.listViewID);
        listaitens.setAdapter(adaptador);
    }

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                getApplicationContext(),
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                itens
//        );

//        listaitens.setAdapter(adapter);
//
//        listaitens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                int codigoPosicao = i;
//                String valorClicado = (String) listaitens.getItemAtPosition(codigoPosicao);
//                Toast.makeText(getApplicationContext(),valorClicado,Toast.LENGTH_SHORT).show();
//                dialog = new AlertDialog.Builder(Listar_todos.this);
//                dialog.setTitle("Teste");
//                dialog.setMessage("BLbalablab");
//                dialog.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(Listar_todos.this, "Pressionou botao nao",Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//                dialog.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(Listar_todos.this, "Pressionou o botao Sim",Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dialog.create();
//                dialog.show();
//            }
//        });
////    }
}
