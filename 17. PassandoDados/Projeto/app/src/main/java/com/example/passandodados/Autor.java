package com.example.passandodados;

import java.io.Serializable;

public class Autor implements Serializable {

    private String nome;
    private String github;
    private String email;

    public Autor(String nome, String github, String email) {
        this.nome = nome;
        this.github = github;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
