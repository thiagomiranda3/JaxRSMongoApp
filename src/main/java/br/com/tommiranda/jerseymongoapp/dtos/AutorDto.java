package br.com.tommiranda.jerseymongoapp.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
