package com.example.toggleswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch swSenha;
    private ToggleButton tgSenha;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swSenha   = findViewById(R.id.swSenha);
        tgSenha   = findViewById(R.id.tgSenha);
        txtResult = findViewById(R.id.txtResult);

        adicionarListener();
    }

    public void adicionarListener(){
        swSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    txtResult.setText("Switch ligado");
                } else {
                    txtResult.setText("Switch desligado");
                }
            }
        });

        tgSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    txtResult.setText("Toggle ligado");
                } else {
                    txtResult.setText("Toggle desligado");
                }
            }
        });
    }

    public void enviar(View view){
        String result = "";
        if (swSenha.isChecked()){
            result += "Switch ligado\n";
        } else {
            result += "Switch desligado\n";
        }

        if (tgSenha.isChecked()){
            result += "Toggle ligado\n";
        } else {
            result += "Toggle desligado\n";
        }

        txtResult.setText(result);
    }
}
