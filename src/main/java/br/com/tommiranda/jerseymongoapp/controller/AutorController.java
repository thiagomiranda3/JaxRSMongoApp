/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tommiranda.jerseymongoapp.controller;

import br.com.tommiranda.jerseymongoapp.mongoutils.CollectionNames;
import br.com.tommiranda.jerseymongoapp.mongoutils.MongoConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.Document;

@Path("autor")
@Produces(MediaType.APPLICATION_JSON)
public class AutorController {

    @GET
    public Response index(){
        return Response.ok("Autor a ser implementado!").build();
    }
    
    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        MongoDatabase db = MongoConnection.getConnection();
        MongoCollection<Document> collection = db.getCollection(CollectionNames.Autor);

        return null;
    }
}
