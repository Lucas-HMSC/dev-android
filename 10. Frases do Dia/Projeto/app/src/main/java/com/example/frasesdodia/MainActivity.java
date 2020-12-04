package com.example.frasesdodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view){

        String[] frases = {
                "Se você traçar metas absurdamente altas e falhar, seu fracasso será muito melhor que o sucesso de todos - James Cameron",
                "O sucesso normalmente vem para quem está ocupado demais para procurar por ele - Henry David Thoreau",
                "A vida é melhor para aqueles para quem fazem o possível para terem o melhor – John Wooden",
                "Se você não está disposto a arriscar, esteja disposto a uma vida comum - Jim Rohn",
                "Pare de perseguir o dinheiro e comece a perseguir o sucesso - Tony Hsieh",
                "Todos os seus sonhos podem se tornar realidade se você tem coragem para persegui-los - Walt Disney",
        };

        int aleat = new Random().nextInt(4);

        TextView texto = findViewById(R.id.textResult);
        texto.setText(frases[aleat]);
    }

}
