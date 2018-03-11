package br.com.tommiranda.jerseymongoapp.dtos;

public class EventoDto {

    public String id;
    public String nome;
    public String descricao;
    public EnderecoDto endereco;
    public AutorDto autor;

    public EventoDto() {
    }

    public EventoDto(String hexId, String nome, String descricao, EnderecoDto endereco, AutorDto autor) {
        this.id = hexId;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.autor = autor;
    }
}
