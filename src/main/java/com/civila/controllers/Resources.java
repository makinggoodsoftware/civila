package com.civila.controllers;

import com.civila.services.CiviblockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("current")
public class Resources {
 	private final CiviblockService civiblockService;

	@Autowired
	public Resources(CiviblockService civiblockService) {
		this.civiblockService = civiblockService;
	}


	@GET
	@Path("grid")
	@Produces("application/json")
	public Response grid(){
		return Response.status(200).entity(civiblockService.retrieveGrid(-5, -2, 5, 2)).build();
	}

}
