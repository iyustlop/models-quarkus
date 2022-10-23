package com.olivar.models;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ModelResource {
    @GET
    public List<Model> getall(){
        return Model.listAll();
    }

    @POST
    @Transactional
    public Response addOne(Model item){
        item.persist();
        return Response.status(Status.CREATED).entity(item).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id){
        Model model = Model.findById(id);
        model.delete();
        return Response.noContent().build();
    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response updateOne(@PathParam("id") Long id, Model model){
        Model modelRetrieved = Model.findById(id);
        modelRetrieved.id = model.id;
        modelRetrieved.denomination = model.denomination;
        modelRetrieved.onSale = model.onSale;
        modelRetrieved.production = model.production;
        return Response.ok(modelRetrieved).build();
    }
    
}
