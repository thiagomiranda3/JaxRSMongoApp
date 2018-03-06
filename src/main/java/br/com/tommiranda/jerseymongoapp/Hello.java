package br.com.tommiranda.jerseymongoapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("hello")
public class Hello {
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ola(@PathParam("name") String name){
        return Response.ok("Hello " + name).build();
    }
}
