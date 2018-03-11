package br.com.tommiranda.jerseymongoapp.dtos;

public class EnderecoDto {

    public String rua;
    public Integer numero;
    public String cidade;
    public String estado;

    public EnderecoDto() {
    }

    public EnderecoDto(String rua, Integer numero, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }
}
