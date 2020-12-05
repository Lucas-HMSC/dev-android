package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listRoot;
    private String[] itens = {
            "Desenvolvedor", "Administrador de Banco de Dados",
            "Engenheiro de Software", "Administrador de Redes",
            "Analista de Sistemas", "Cientista de Dados",
            "Engenheiro de IA", "Scrum master",
            "Gerente de TI", "Arquiteto de Software",
            "Designer de interfaces", "Engenheiro de Testes",
            "Gerente de Projeto", "Diretor de TI",
            "Analista de Segurança", "Professor de TI",
            "Suporte Técnico", "Analista de Dados",
            "Analista de Infra", "Analista de Suporte Linux"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listRoot = findViewById(R.id.listRoot);

        // Cria adaptador para a Lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        // Adiciona adaptador para a Lista
        listRoot.setAdapter(adaptador);

        // Adiciona clique na Lista
        listRoot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = listRoot.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Profissão: " + valorSelecionado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
