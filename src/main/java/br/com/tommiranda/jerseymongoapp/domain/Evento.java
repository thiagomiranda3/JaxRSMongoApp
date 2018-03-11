package br.com.tommiranda.jerseymongoapp.domain;

import org.bson.types.ObjectId;

public class Evento {

    private final ObjectId _id;
    private final String nome;
    private final String descricao;
    private final Endereco endereco;
    private final Autor autor;

    public Evento(ObjectId _id, String nome, String descricao, Endereco endereco, Autor autor) {
        this._id = _id;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.autor = autor;
    }

    public String hexId() {
        return _id.toHexString();
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

    public Autor getAutor() {
        return autor;
    }
}
