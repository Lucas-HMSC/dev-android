package com.example.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // Cria o banco de dados
            SQLiteDatabase database = openOrCreateDatabase("app", MODE_PRIVATE, null);
            // Cria tabela
            /*
            database.execSQL(
                    "CREATE TABLE IF NOT EXISTS pessoas " +
                            "(nome VARCHAR," +
                            "idade INT(3))"
            );*/
            database.execSQL(
                    "CREATE TABLE IF NOT EXISTS pessoas " +
                            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "nome VARCHAR," +
                            "idade INT(3))"
            );

            // Deleta tabela
            //database.execSQL("DROP TABLE pessoas");

            // Insere dados
            /*
            database.execSQL(
                    "INSERT INTO pessoas(nome, idade) VALUES" +
                            "('Lucas', 21)"
            );
            database.execSQL(
                    "INSERT INTO pessoas(nome, idade) VALUES" +
                            "('Maria', 18)"
            );
            database.execSQL(
                    "INSERT INTO pessoas(nome, idade) VALUES" +
                            "('Mariana', 35)"
            );
            database.execSQL(
                    "INSERT INTO pessoas(nome, idade) VALUES" +
                            "('Pedro', 50)"
            );
            database.execSQL(
                    "INSERT INTO pessoas(nome, idade) VALUES" +
                            "('Jamilton', 30)"
            );
            database.execSQL(
                    "INSERT INTO pessoas(nome, idade) VALUES" +
                            "('Elaine', 40)"
            );*/

            // Atualiza Dados
            //database.execSQL("UPDATE pessoas SET idade = 19 WHERE nome = 'Mariana'");
            //database.execSQL("UPDATE pessoas SET idade = 19, nome = 'Elaine Cristina' WHERE id = 4 ");

            // Deleta Dados
            database.execSQL("DELETE FROM pessoas WHERE id = 3");

            // Recupera pessoas
            //String consulta = "SELECT nome, idade FROM pessoas";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade >= 30 OR idade = 18";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade IN (21, 18)";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome IN ('Lucas', 'Maria')";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade BETWEEN 30 AND 35";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE 'lu%'";
            //String consulta = "SELECT id, nome, idade FROM pessoas WHERE 1=1 ORDER BY idade";
            String consulta = "SELECT * FROM pessoas";
            Cursor cursor = database.rawQuery(consulta, null);

            // Indices da Tabela
            int indiceID = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null){
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                String id = cursor.getString(indiceID);

                Log.i("RESULTADO - id ", id + ", nome: " + nome + ", idade: " + idade);

                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
