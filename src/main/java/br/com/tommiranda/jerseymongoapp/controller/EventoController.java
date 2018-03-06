package br.com.tommiranda.jerseymongoapp.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("evento")
@Produces(MediaType.APPLICATION_JSON)
public class EventoController {
    
    @GET
    public Response index(){
        return Response.ok("Evento a ser implementado!").build();
    }
}
