package br.com.tommiranda.jerseymongoapp.domain;

public class Endereco {

    private final String rua;
    private final Integer numero;
    private final String cidade;
    private final String estado;

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
