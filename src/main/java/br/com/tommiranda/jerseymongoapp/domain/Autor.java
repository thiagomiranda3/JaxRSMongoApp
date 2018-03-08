package br.com.tommiranda.jerseymongoapp.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.bson.types.ObjectId;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Autor {

    private ObjectId _id;
    private String nome;
    private String email;

    public Autor() {
    }

    public Autor(ObjectId _id, String nome, String email) {
        this._id = _id;
        this.nome = nome;
        this.email = email;
    }

    public ObjectId getId() {
        return _id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
