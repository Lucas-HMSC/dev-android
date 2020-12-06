package com.example.passandodados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                // Instanciar o objeto
                Autor lucas = new Autor("Lucas Carvalho", "Lucas-HMSC", "lucasms.carvalho@gmail.com");

                // Passar Dados
                intent.putExtra("nome", "Lucas Carvalho");
                intent.putExtra("url", "https://github.com/Lucas-HMSC");
                intent.putExtra("objeto", lucas);

                startActivity(intent);
            }
        });

    }
}
