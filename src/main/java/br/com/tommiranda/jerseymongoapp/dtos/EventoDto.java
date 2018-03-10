package br.com.tommiranda.jerseymongoapp.dtos;

import br.com.tommiranda.jerseymongoapp.domain.Endereco;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EventoDto {

    public String _id;
    public String nome;
    public String descricao;
    public EnderecoDto endereco;
    public AutorDto autor;

    public EventoDto() {
    }

    public EventoDto(String _id, String nome, String descricao, EnderecoDto endereco, AutorDto autor) {
        this._id = _id;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.autor = autor;
    }
}
