package br.com.tommiranda.jerseymongoapp.mapper;

import br.com.tommiranda.jerseymongoapp.domain.Autor;
import br.com.tommiranda.jerseymongoapp.domain.Endereco;
import br.com.tommiranda.jerseymongoapp.domain.Evento;
import br.com.tommiranda.jerseymongoapp.dtos.EnderecoDto;
import br.com.tommiranda.jerseymongoapp.dtos.EventoDto;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public final class EventoMapper {

    public EventoMapper() {
    }

    public static Document toDocument(final Evento evento) {
        return new Document("nome", evento.getNome())
                .append("descricao", evento.getDescricao())
                .append("autor", AutorMapper.toDocument(evento.getAutor()))
                .append("endereco", toDocument(evento.getEndereco()));
    }

    private static Document toDocument(final Endereco endereco) {
        return new Document("rua", endereco.getRua())
                .append("numero", endereco.getNumero())
                .append("cidade", endereco.getCidade())
                .append("estado", endereco.getEstado());
    }

    public static Evento toEvento(final Document document) {
        ObjectId _id = document.get("_id", ObjectId.class);
        String nome = document.get("nome", String.class);
        String descricao = document.get("descricao", String.class);
        Autor autor = AutorMapper.toAutor(document.get("autor", Document.class));
        Endereco endereco = toEndereco(document.get("endereco", Document.class));

        return new Evento(_id, nome, descricao, endereco, autor);
    }

    private static Endereco toEndereco(final Document document) {
        String rua = document.get("rua", String.class);
        Integer numero = document.get("numero", Integer.class);
        String cidade = document.get("cidade", String.class);
        String estado = document.get("estado", String.class);

        return new Endereco(rua, numero, cidade, estado);
    }

    public static Evento toEvento(final EventoDto eventoDto) {
        ObjectId eventoId = null;

        if (eventoDto._id != null) {
            eventoId = new ObjectId(eventoDto._id);
        }

        return new Evento(
                eventoId,
                eventoDto.nome,
                eventoDto.descricao,
                toEndereco(eventoDto.endereco),
                AutorMapper.toAutor(eventoDto.autor)
        );
    }

    private static Endereco toEndereco(final EnderecoDto enderecoDto) {
        return new Endereco(
                enderecoDto.rua,
                enderecoDto.numero,
                enderecoDto.cidade,
                enderecoDto.estado
        );
    }

    public static EventoDto toEventoDto(final Evento evento) {
        return new EventoDto(
                evento.getId().toString(),
                evento.getNome(),
                evento.getDescricao(),
                toEnderecoDto(evento.getEndereco()),
                AutorMapper.toAutorDto(evento.getAutor())
        );
    }

    private static EnderecoDto toEnderecoDto(final Endereco endereco) {
        return new EnderecoDto(
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado()
        );
    }

    public static List<EventoDto> toListEventoDto(final List<Evento> eventos) {
        List<EventoDto> eventosDto = new ArrayList<>();

        for (Evento e : eventos) {
            eventosDto.add(toEventoDto(e));
        }

        return eventosDto;
    }
}
