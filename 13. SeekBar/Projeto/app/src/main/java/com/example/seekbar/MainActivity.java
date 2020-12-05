 package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarEscala;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarEscala = findViewById(R.id.seekBarEscala);
        txtResult     = findViewById(R.id.txtResult);

        seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtResult.setText("Progresso: " + progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void recuperarProg(View view){
        String nivel = "";
        if (seekBarEscala.getProgress() >= 0 && seekBarEscala.getProgress() < 3){
            nivel = "Não sou divertido(a)";
        } else if (seekBarEscala.getProgress() >= 3 && seekBarEscala.getProgress() < 7) {
            nivel = "Sou uma pessoa divertida";
        } else {
            nivel = "Sou muito divertido(a)";
        }

        txtResult.setText("Escolhido: " + nivel);

    }
}
