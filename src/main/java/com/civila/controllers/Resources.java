package com.civila.controllers;

import com.civila.services.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("current")
public class Resources {
 	private final GridService gridService;

	@Autowired
	public Resources(GridService gridService) {
		this.gridService = gridService;
	}

	@GET
	@Path("grid")
	@Produces("application/json")
	public Response grid(){
		return Response.status(200).entity(gridService.retrieveGrid()).build();
	}

}
