package com.example.cardview.model;

public class Postagem {

    private String nome, post;
    private int imagem;

    public Postagem() {

    }

    public Postagem(String nome, String post, int imagem) {
        this.nome = nome;
        this.post = post;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
