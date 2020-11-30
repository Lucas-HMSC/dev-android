package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    private TextView txtResult;
    private TextInputEditText txtEmail;

    private CheckBox cbFront, cbBack, cbFull;

    private RadioButton sexoMasc, sexoFem;
    private RadioGroup optSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Texto
        txtNome     = findViewById(R.id.txtNome);
        txtResult   = findViewById(R.id.txtResult);
        txtEmail    = findViewById(R.id.txtEmail);

        // CheckBox
        cbFront     = findViewById(R.id.cbFront);
        cbBack      = findViewById(R.id.cbBack);
        cbFull      = findViewById(R.id.cbFull);

        // RadioButton
        sexoMasc    = findViewById(R.id.rdMasc);
        sexoFem     = findViewById(R.id.rdFem);
        optSexo     = findViewById(R.id.rgSexo);

    }

    public String radioButton(){
        String sexo = "";
        if(sexoMasc.isChecked()){
            sexo = sexoMasc.getText().toString();
        } else if (sexoFem.isChecked()) {
            sexo = sexoFem.getText().toString();
        }

        return sexo;
    }

    public String checkBox() {
        String area = "";
        if (cbFront.isChecked()) {
            area += cbFront.getText().toString() + "\n";
        }
        if (cbBack.isChecked()) {
            area += cbBack.getText().toString() + "\n";
        }
        if (cbFull.isChecked()) {
            area += cbFull.getText().toString() + "\n";
        }

        return area;
    }

    public void enviar(View view){
        String nome = txtNome.getText().toString();
        String email = txtEmail.getText().toString();
        txtResult.setText("Nome: " + nome + "\nEmail: " + email + "\nSexo: " + radioButton() + "\nÁrea(s) de Interesse: \n" + checkBox());
    }

    public void limpar(View view){
        txtNome.setText("");
        txtEmail.setText("");
        txtResult.setText("Resultado");
        if(cbFull.isChecked()){
            cbFull.setChecked(false);
        }
        if(cbFront.isChecked()){
            cbFront.setChecked(false);
        }
        if(cbBack.isChecked()){
            cbBack.setChecked(false);
        }
        if(sexoMasc.isChecked()){
            sexoMasc.setChecked(false);
        }
        if(sexoFem.isChecked()){
            sexoFem.setChecked(false);
        }
    }
}
