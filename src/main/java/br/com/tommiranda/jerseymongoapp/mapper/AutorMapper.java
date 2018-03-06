package br.com.tommiranda.jerseymongoapp.mapper;

import br.com.tommiranda.jerseymongoapp.domain.Autor;
import org.bson.Document;

public final class AutorMapper {

    private AutorMapper() {
    }

    public static Document toDocument(final Autor autor) {
        return new Document("id", autor.getId())
                .append("nome", autor.getNome())
                .append("email", autor.getEmail());
    }
}
