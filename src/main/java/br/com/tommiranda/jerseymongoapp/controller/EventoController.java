package br.com.tommiranda.jerseymongoapp.controller;

import br.com.tommiranda.jerseymongoapp.core.NoticationSuccess;
import br.com.tommiranda.jerseymongoapp.core.Notification;
import br.com.tommiranda.jerseymongoapp.core.NotificationError;
import br.com.tommiranda.jerseymongoapp.domain.Evento;
import br.com.tommiranda.jerseymongoapp.mapper.EventoMapper;
import br.com.tommiranda.jerseymongoapp.repository.EventoRepository;
import br.com.tommiranda.jerseymongoapp.dtos.EventoDto;
import br.com.tommiranda.jerseymongoapp.validator.EventoDtoValidator;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

@Path("eventos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventoController {

    private final EventoRepository eventoRepository;
    private final EventoDtoValidator dtoValidator;

    public EventoController() {
        this.dtoValidator = new EventoDtoValidator();
        this.eventoRepository = new EventoRepository();
    }

    @GET
    public List<EventoDto> getAll() {
        List<Evento> eventos = eventoRepository.getAll();
        return EventoMapper.toListEventoDto(eventos);
    }

    @GET
    @Path("/{id}")
    public EventoDto getById(@PathParam("id") String id) {
        Evento evento = eventoRepository.findById(id);
        return EventoMapper.toEventoDto(evento);
    }

    @POST
    public Notification add(EventoDto eventoDto) {
        if (!dtoValidator.Validate(eventoDto))
            return new NotificationError(dtoValidator.showErrors());

        if (eventoRepository.add(EventoMapper.toEvento(eventoDto))) {
            //URI uri = uriInfo.getAbsolutePathBuilder()
            //       .path("XXX")
            //      .build();

            return new NoticationSuccess(eventoDto);
        }
        
        return new NotificationError(null);
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") String id, EventoDto eventoDto) {
        if (!dtoValidator.Validate(eventoDto)) {
            return Response.status(Status.BAD_REQUEST)
                    .entity(new NotificationError(dtoValidator.showErrors()))
                    .build();
        }

        if (eventoRepository.update(id, EventoMapper.toEvento(eventoDto))) {
            return Response.ok()
                    .entity("Evendo atualizado com sucesso!")
                    .build();
        } else {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Houve problemas na atualização do evento")
                    .build();
        }
    }
}
