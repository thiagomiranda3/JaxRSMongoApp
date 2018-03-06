package br.com.tommiranda.jerseymongoapp.domain;

public class Evento {

    private int id;
    private String nome;
    private String descricao;
    private Endereco endereco;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
