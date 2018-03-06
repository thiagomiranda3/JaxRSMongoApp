package br.com.tommiranda.jerseymongoapp.mapper;

import br.com.tommiranda.jerseymongoapp.domain.Endereco;
import br.com.tommiranda.jerseymongoapp.domain.Evento;
import org.bson.Document;

public final class EventoMapper {

    public EventoMapper() {
    }

    public static Document toDocument(final Evento evento) {
        return new Document("id", evento.getId())
                .append("nome", evento.getNome())
                .append("descricao", evento.getDescricao())
                .append("endereco", toDocument(evento.getEndereco()));
    }

    public static Document toDocument(final Endereco endereco) {
        return new Document("rua", endereco.getRua())
                .append("numero", endereco.getNumero())
                .append("cidade", endereco.getCidade())
                .append("estado", endereco.getEstado());
    }
}
