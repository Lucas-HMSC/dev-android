package com.example.passandodados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txtNome, txtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtNome = findViewById(R.id.txtNome);
        txtUrl = findViewById(R.id.txtUrl);

        // Recuperar os dados enviados
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome");
        String url = dados.getString("url");
        Autor lucas = (Autor) dados.getSerializable("objeto");

        // Configurar valores recuperados
        //txtNome.setText(nome);
        //txtUrl.setText(url);
        txtNome.setText(lucas.getNome());
        txtUrl.setText(lucas.getEmail());
    }
}
