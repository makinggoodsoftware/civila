package com.civila.controllers

import com.civila.data.cities.Titani
import groovy.json.JsonBuilder

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

@Path("currentG")
class ResourcesG {
    @GET
    @Path("titani")
    @Produces("application/json")
    public Response titani(){
        return Response.status(200).entity(
                new JsonBuilder(new Titani().build()).toPrettyString()
        ).build();
    }
}
