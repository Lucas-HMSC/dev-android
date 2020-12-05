 package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirDialog(View view) {
        // Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        // Configurar Titulo e Mensagem
        dialog.setTitle("Utilizando Dialog's");
        dialog.setMessage("Mensagem do Dialog. Escolha Sim ou Não para sair:");

        // Configurar Cancelamento
        dialog.setCancelable(false);

        // Configurar Icone
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        // Configurar Ações para Sim e Nao
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(
                        getApplicationContext(),
                        "Ação executada ao clicar no botão Sim",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(
                        getApplicationContext(),
                        "Ação executada ao clicar no botão Não",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        // Criar e Exibir o AlertDialog
        dialog.create();
        dialog.show();
    }
}
