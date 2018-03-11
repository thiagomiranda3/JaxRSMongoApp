package br.com.tommiranda.jerseymongoapp.controller;

import br.com.tommiranda.jerseymongoapp.core.NotificationError;
import br.com.tommiranda.jerseymongoapp.core.NotificationException;
import br.com.tommiranda.jerseymongoapp.core.NotificationSuccess;
import br.com.tommiranda.jerseymongoapp.domain.Evento;
import br.com.tommiranda.jerseymongoapp.dtos.EventoDto;
import br.com.tommiranda.jerseymongoapp.mapper.EventoMapper;
import br.com.tommiranda.jerseymongoapp.repository.EventoRepository;
import br.com.tommiranda.jerseymongoapp.validator.EventoDtoValidator;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

    private final EventoMapper mapper;
    private final EventoRepository repository;
    private final EventoDtoValidator dtoValidator;

    public EventoController() {
        this.mapper = new EventoMapper();
        this.dtoValidator = new EventoDtoValidator();
        this.repository = new EventoRepository();
    }

    @GET
    public List<EventoDto> getAll() {
        List<Evento> eventos = repository.getAll();
        return mapper.toListEventoDto(eventos);
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") String id) {
        Evento evento = repository.findById(id);

        if (evento == null)
            return Response.status(Status.NOT_FOUND)
                    .entity(new NotificationException("Evento não cadastrado"))
                    .build();

        return Response.status(Status.OK)
                .entity(mapper.toEventoDto(evento))
                .build();
    }

    @POST
    public Response add(EventoDto eventoDto, @Context UriInfo uriInfo) {
        if (!dtoValidator.Validate(eventoDto))
            return Response.status(Status.BAD_REQUEST)
                    .entity(new NotificationError(dtoValidator.showErrors()))
                    .build();

        try {
            Evento evento = repository.add(mapper.toEvento(eventoDto));

            URI location = uriInfo.getAbsolutePathBuilder()
                    .path(evento.hexId())
                    .build();

            return Response.status(Status.CREATED)
                    .entity(new NotificationSuccess(mapper.toEventoDto(evento)))
                    .contentLocation(location)
                    .build();
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST)
                    .entity(new NotificationException(e.getMessage()))
                    .build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") String id, EventoDto eventoDto) {
        if (!dtoValidator.Validate(eventoDto))
            return Response.status(Status.BAD_REQUEST)
                    .entity(new NotificationError(dtoValidator.showErrors()))
                    .build();

        try {
            if (repository.update(id, mapper.toEvento(eventoDto)))
                return Response.ok(new NotificationSuccess(eventoDto))
                        .build();

            return Response.status(Status.NOT_FOUND)
                    .entity(new NotificationException("Evento não cadastrado"))
                    .build();
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST)
                    .entity(new NotificationException(e.getMessage()))
                    .build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            if (repository.delete(id))
                return Response.status(Status.OK)
                        .entity(new NotificationSuccess("Evento excluido com sucesso"))
                        .build();
            else
                return Response.status(Status.NOT_FOUND)
                        .entity(new NotificationException("Evento não cadastrado"))
                        .build();
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST)
                    .entity(new NotificationException(e.getMessage()))
                    .build();
        }
    }
}
