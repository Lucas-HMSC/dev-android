package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button btnSalvar;
    private TextInputEditText inputNome;
    private TextView txtUsuario;
    private static final String ARQ_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalvar = findViewById(R.id.btnSalvar);
        inputNome = findViewById(R.id.inputNome);
        txtUsuario = findViewById(R.id.txtUsuario);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQ_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

                if (inputNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "Preencha o nome",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String nome = inputNome.getText().toString();
                    editor.putString("Nome", nome);
                    editor.commit();

                    txtUsuario.setText("Olá, " + nome + "!");
                }
            }
        });

        // Recupera os dados salvos
        SharedPreferences preferences = getSharedPreferences(ARQ_PREFERENCIA, 0);

        // Valida se possui o nome em preferencias
        if (preferences.contains("nome")){
            String nome = preferences.getString("nome", "usuário não definido");
            txtUsuario.setText("Olá " + nome + "!");
        } else {
            txtUsuario.setText("Olá, usuário não definido!");
        }
    }
}
