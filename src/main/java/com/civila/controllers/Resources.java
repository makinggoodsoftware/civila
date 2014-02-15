package com.civila.controllers;

import com.civila.services.secure.SecureCiviblockService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("current")
public class Resources {
 	private final SecureCiviblockService secureCiviblockService;

	public Resources(SecureCiviblockService secureCiviblockService) {
		this.secureCiviblockService = secureCiviblockService;
	}


	@GET
	@Path("grid")
	@Produces("application/json")
	public Response grid(){
		return Response.status(200).entity(secureCiviblockService.retrieveGrid(-5, -2, 5, 2)).build();
	}

}
