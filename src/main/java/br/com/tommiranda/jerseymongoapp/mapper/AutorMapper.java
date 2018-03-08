package br.com.tommiranda.jerseymongoapp.mapper;

import br.com.tommiranda.jerseymongoapp.domain.Autor;
import org.bson.Document;
import org.bson.types.ObjectId;

public final class AutorMapper {

    private AutorMapper() {
    }

    public static Document toDocument(final Autor autor) {
        return new Document("nome", autor.getNome())
                .append("email", autor.getEmail());
    }
    
    public static Autor toAutor(final Document document) {
        ObjectId _id = document.get("_id", ObjectId.class);
        String nome = document.get("nome", String.class);
        String email = document.get("email", String.class);
        
        return new Autor(_id, nome, email);
    }
}
