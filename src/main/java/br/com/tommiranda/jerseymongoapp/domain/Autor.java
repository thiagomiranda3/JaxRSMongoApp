package br.com.tommiranda.jerseymongoapp.domain;

import org.bson.types.ObjectId;

public class Autor {

    private String nome;
    private String email;

    public Autor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
