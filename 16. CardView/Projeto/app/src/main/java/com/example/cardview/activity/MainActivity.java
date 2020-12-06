 package com.example.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.cardview.R;
import com.example.cardview.adapter.PostAdapter;
import com.example.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPost;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPost = findViewById(R.id.recyclerView);

        // Define o Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerPost.setLayoutManager(layoutManager);

        // Define o Adapter
        this.prepararPostagens();
        PostAdapter adapter = new PostAdapter(postagens);
        recyclerPost.setAdapter(adapter);
    }

    public void prepararPostagens(){
        Postagem post = new Postagem("Lucas Carvalho", "#tbt Viagem Legal!!", R.drawable.imagem1);
        this.postagens.add(post);

        post = new Postagem("Maria Clara", "#Paris", R.drawable.imagem3);
        this.postagens.add(post);

        post = new Postagem("Elaine Cristina", "Que foto linda!", R.drawable.imagem4);
        this.postagens.add(post);

        post = new Postagem("Hotel JM", "Viaje, aproveite nossos descontos!", R.drawable.imagem2);
        this.postagens.add(post);
    }
}
