package com.civila.controllers;

import com.civila.model.NavigationRequest;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("actions")
public class Actions {
	@POST
	@Path("navigate")
	@Produces("application/json")
	public Response navigate(NavigationRequest navigationRequest){
		return Response.status(200).entity(true).build();
	}
}
