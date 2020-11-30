package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView imageResult = findViewById(R.id.imageResult);
        TextView textResult = findViewById(R.id.textResult);

        int num = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[num];

        switch (opcaoApp) {
            case "pedra":
                imageResult.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResult.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResult.setImageResource(R.drawable.tesoura);
                break;
        }

        if(     //App ganhador
                (opcaoSelecionada == "pedra" && opcaoApp == "papel") ||
                (opcaoSelecionada == "papel" && opcaoApp == "tesoura") ||
                (opcaoSelecionada == "tesoura" && opcaoApp == "pedra")){
            textResult.setText("Você perdeu :(");
        } else if(//Usuario ganhador
                (opcaoSelecionada == "pedra" && opcaoApp == "tesoura") ||
                        (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
                        (opcaoSelecionada == "tesoura" && opcaoApp == "papel")){
            textResult.setText("Você ganhou :)");
        } else { //Empate
            textResult.setText("Empatamos ;)");
        }
    }

}
