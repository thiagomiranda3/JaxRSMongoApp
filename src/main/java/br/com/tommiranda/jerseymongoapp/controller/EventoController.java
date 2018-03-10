package br.com.tommiranda.jerseymongoapp.controller;

import br.com.tommiranda.jerseymongoapp.domain.Evento;
import br.com.tommiranda.jerseymongoapp.mapper.EventoMapper;
import br.com.tommiranda.jerseymongoapp.repository.EventoRepository;
import br.com.tommiranda.jerseymongoapp.dtos.EventoDto;
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

    public EventoController() {
        eventoRepository = new EventoRepository();
    }

    @GET
    public Response getAll() {
        List<Evento> eventos = eventoRepository.getAll();
        return Response.ok(EventoMapper.toListEventoDto(eventos)).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") String id) {
        Evento evento = eventoRepository.findById(id);
        return Response.ok(EventoMapper.toEventoDto(evento)).build();
    }

    @POST
    public Response add(EventoDto eventoDto) {
        if (eventoDto == null) {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Evento não pode ser nulo!")
                    .build();
        }

        if (eventoRepository.add(EventoMapper.toEvento(eventoDto))) {
            //URI uri = uriInfo.getAbsolutePathBuilder()
            //       .path("XXX")
            //      .build();

            return Response.ok()
                    .entity("Evendo criado com sucesso!")
                    .build();
        } else {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Houve problemas na criação do evento")
                    .build();
        }
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") String id, EventoDto eventoDto) {
        if (eventoDto == null) {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Evento não pode ser nulo!")
                    .build();
        }

        if (eventoRepository.update(id, EventoMapper.toEvento(eventoDto))) {
            //URI uri = uriInfo.getAbsolutePathBuilder()
            //       .path("XXX")
            //      .build();

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
