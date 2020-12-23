package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuarioAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference usuarios = referencia.child("usuarios");
        DatabaseReference produtos = referencia.child("produtos");

        /* Inserção de Dados
        Usuario usuario = new Usuario();
        // 001 (forma manual)
        usuario.setNome("Lucas");
        usuario.setSobrenome("Carvalho");
        usuario.setIdade(21);
        usuarios.child("001").setValue(usuario);
        // -MOxBi9Y97AsgjffCDBg (forma automática)
        usuario.setNome("Lucas");
        usuario.setSobrenome("Carvalho");
        usuario.setIdade(21);
        usuarios.push().setValue(usuario);

        // 002 (forma manual)
        usuario.setNome("Maria");
        usuario.setSobrenome("Clara");
        usuario.setIdade(18);
        usuarios.child("002").setValue(usuario);
        // -MOxC1_3CEe9vOjKBhGs (forma automática)
        usuario.setNome("Maria");
        usuario.setSobrenome("Clara");
        usuario.setIdade(18);
        usuarios.push().setValue(usuario);

        usuario.setNome("Jamilton");
        usuario.setSobrenome("Damasceno");
        usuario.setIdade(30);
        usuarios.push().setValue(usuario);

        usuario.setNome("José");
        usuario.setSobrenome("Renato");
        usuario.setIdade(31);
        usuarios.push().setValue(usuario);

        usuario.setNome("Mariana");
        usuario.setSobrenome("Silvério");
        usuario.setIdade(45);
        usuarios.push().setValue(usuario);

        usuario.setNome("Marcelo");
        usuario.setSobrenome("Farias");
        usuario.setIdade(18);
        usuarios.push().setValue(usuario);

        usuario.setNome("Ana");
        usuario.setSobrenome("Ribeiro");
        usuario.setIdade(22);
        usuarios.push().setValue(usuario);

        usuario.setNome("Rodrigo");
        usuario.setSobrenome("Matos");
        usuario.setIdade(35);
        usuarios.push().setValue(usuario);
        */

        /*
        Produto produto = new Produto();
        // 001
        produto.setDescricao("Redmi Note 5");
        produto.setMarca("Xiaomi");
        produto.setPreco(1200);
        produtos.child("001").setValue(produto);
        // 002
        produto.setDescricao("Moto G6");
        produto.setMarca("Motorola");
        produto.setPreco(1500);
        produtos.child("002").setValue(produto);
        */

        /* Retorno dos Dados
        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
         */

        // Cadastro de usuario
        /*
        usuarioAuth.createUserWithEmailAndPassword(
                "lucashms.carvalho@gmail.com",
                "lucas123"
        ).addOnCompleteListener(
                MainActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("CreateUser", "Sucesso ao cadastrar usuário!");
                        } else {
                            Log.i("CreateUser", "Erro ao cadastrar usuário!");
                        }
                    }
                }
        );
        */

        // Verifica usuário logado
        /*
        if (usuarioAuth.getCurrentUser() != null){
            Log.i("CurrentUser", "Usuário logado!");
        } else {
            Log.i("CurrentUser", "Usuário não logado!");
        }
        */

        // Logout
        //usuarioAuth.signOut();

        // Login
        /*
        usuarioAuth.signInWithEmailAndPassword(
                "lucashms.carvalho@gmail.com",
                "lucas123"
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.i("signIn", "Sucesso ao logar usuário!");
                } else {
                    Log.i("signIn", "Erro ao logar usuário!");
                }
            }
        });
        */

        // Pesquisando dados com filtros
        /* Utilizando ID como filtro
        DatabaseReference usuarioPesquisa = usuarios.child("-MOxBi9Y97AsgjffCDBg");
        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Usuario dadosUsuario = dataSnapshot.getValue(Usuario.class);
                Log.i("Dados Usuario", "Usuário com o nome " + dadosUsuario.getNome() + " possui idade de " + dadosUsuario.getIdade() + " anos.");
                //Log.i("Dados Usuario", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        */

        // Utilizando Query como filtro
        //Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Maria");
        //Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);
        //Query usuarioPesquisa = usuarios.orderByKey().limitToLast(2);

        // Maior ou igual (>=)
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(40);
        // Menos ou igual (<=)
        //Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(22);

        // Entre dois valores
        /*Query usuarioPesquisa = usuarios.orderByChild("idade")
                                        .startAt(18)
                                        .endAt(22);*/

        // Filtrar palavras (nomes que comecem com a letra J)
        /*
        Query usuarioPesquisa = usuarios.orderByChild("nome")
                                        .startAt("J")
                                        .endAt("J" + "\uf8ff");

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("Dados Usuario", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        */
    }
}