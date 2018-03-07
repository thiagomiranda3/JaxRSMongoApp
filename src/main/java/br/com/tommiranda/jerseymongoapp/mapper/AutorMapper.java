package br.com.tommiranda.jerseymongoapp.mapper;

import br.com.tommiranda.jerseymongoapp.domain.Autor;
import org.bson.Document;

public final class AutorMapper {

    private AutorMapper() {
    }

    public static Document toDocument(final Autor autor) {
        return new Document("_id", autor.getId())
                .append("nome", autor.getNome())
                .append("email", autor.getEmail());
    }
    
    public static Autor toAutor(final Document document) {
        int _id = document.get("_id", Integer.class);
        String nome = document.get("nome", String.class);
        String email = document.get("email", String.class);
        
        return new Autor(_id, nome, email);
    }
}
