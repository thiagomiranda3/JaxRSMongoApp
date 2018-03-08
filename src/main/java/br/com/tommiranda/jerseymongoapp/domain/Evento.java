package br.com.tommiranda.jerseymongoapp.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Evento {

    private Integer _id;
    private String nome;
    private String descricao;
    private Endereco endereco;
    private Autor autor;

    public Evento() {
    }

    public Evento(Integer _id, String nome, String descricao, Endereco endereco, Autor autor) {
        this._id = _id;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.autor = autor;
    }

    public Integer getId() {
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

    public void setId(Integer _id) {
        this._id = _id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
