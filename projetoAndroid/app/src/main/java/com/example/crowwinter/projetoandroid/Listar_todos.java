package com.example.crowwinter.projetoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Listar_todos extends AppCompatActivity {

    private ListView listaitens;
    private String[] itens = {
            "Anderson F Lima","915125292","Uninove E '10'"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_todos);


        listaitens = (ListView) findViewById(R.id.listViewID);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        listaitens.setAdapter(adapter);

        listaitens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int codigoPosicao = i;
                String valorClicado = (String) listaitens.getItemAtPosition(codigoPosicao);
                Toast.makeText(getApplicationContext(),valorClicado,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
