package br.com.tommiranda.jerseymongoapp.domain;

public class Endereco {
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;

    public Endereco(String rua, Integer numero, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
