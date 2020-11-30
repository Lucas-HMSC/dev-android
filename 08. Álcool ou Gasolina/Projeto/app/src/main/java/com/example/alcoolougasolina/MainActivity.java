package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText prAlcool, prGasolina;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prAlcool    = findViewById(R.id.txtAlcool);
        prGasolina  = findViewById(R.id.txtGasolina);
        txtResult   = findViewById(R.id.txtResult);
    }

    public void calcular(View view){
        // recuperar valores digitados
        String precoAlcool      = prAlcool.getText().toString();
        String precoGasolina    = prGasolina.getText().toString();

        // Validação dos campos digitados
        if (validaCampos(precoAlcool, precoGasolina)) {
            // Convertendo String para Numeros
            Double valorAlcool   = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            if ((valorAlcool / valorGasolina) >= 0.7){
                txtResult.setText("Melhor utilizar Gasolina");
            } else {
                txtResult.setText("Melhor utilizar Álcool");
            }
        } else {
            txtResult.setText("Preencha os preços primeiro!");
        }
    }

    public Boolean validaCampos(String pAlcool, String pGasolina){
        Boolean validado = true;
        if (pAlcool == null || pAlcool.equals("")) {
            validado = false;
        } else if (pGasolina == null || pGasolina.equals("")){
            validado = false;
        }

        return validado;
    }
}
