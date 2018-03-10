package br.com.tommiranda.jerseymongoapp.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
