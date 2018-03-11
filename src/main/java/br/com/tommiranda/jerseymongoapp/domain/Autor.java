package br.com.tommiranda.jerseymongoapp.domain;

public class Autor {

    private final String nome;
    private final String email;

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
