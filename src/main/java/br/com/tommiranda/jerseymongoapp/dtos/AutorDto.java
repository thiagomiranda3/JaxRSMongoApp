package br.com.tommiranda.jerseymongoapp.dtos;

public class AutorDto {

    public String nome;
    public String email;

    public AutorDto() {
    }

    public AutorDto(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
