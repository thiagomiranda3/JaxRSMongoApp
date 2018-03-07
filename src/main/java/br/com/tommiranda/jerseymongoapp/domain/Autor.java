package br.com.tommiranda.jerseymongoapp.domain;

public class Autor {

    private Integer _id;
    private String nome;
    private String email;

    public Autor(int _id, String nome, String email) {
        this._id = _id;
        this.nome = nome;
        this.email = email;
    }
    
    public int getId() {
        return _id;
    }

    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
}
