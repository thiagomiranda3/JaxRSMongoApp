package br.com.tommiranda.jerseymongoapp.domain;

public class Evento {

    private Integer _id;
    private String nome;
    private String descricao;
    private Endereco endereco;
    private Autor autor;

    public Evento(Integer _id, String nome, String descricao, Endereco endereco, Autor autor) {
        this._id = _id;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.autor = autor;
    }

    public int getId() {
        return _id;
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
