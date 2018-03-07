package br.com.tommiranda.jerseymongoapp.controller;

import br.com.tommiranda.jerseymongoapp.domain.Evento;
import br.com.tommiranda.jerseymongoapp.repository.EventoRepository;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

@Path("evento")
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
        return Response.ok(eventos).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        Evento evento = eventoRepository.findById(id);
        return Response.ok(evento).build();
    }

    @POST
    public Response add(Evento evento) {
        if (evento == null) {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Evento não pode ser nulo!")
                    .build();
        }

        if (eventoRepository.add(evento)) {
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
}
