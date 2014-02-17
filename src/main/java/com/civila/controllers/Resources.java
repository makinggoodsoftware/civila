package com.civila.controllers;

import com.civila.services.secure.SecureCiviblockService;
import com.civila.services.secure.SecureTurnService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("current")
public class Resources {
 	private final SecureCiviblockService secureCiviblockService;
	private final SecureTurnService secureTurnService;

	public Resources(SecureCiviblockService secureCiviblockService, SecureTurnService secureTurnService) {
		this.secureCiviblockService = secureCiviblockService;
		this.secureTurnService = secureTurnService;
	}


	@GET
	@Path("grid")
	@Produces("application/json")
	public Response grid(){
		return Response.status(200).entity(secureCiviblockService.retrieveGrid(-5, -2, 5, 2)).build();
	}

	@GET
	@Path("turn")
	@Produces("application/json")
	public Response turn(){
		return Response.status(200).entity(secureTurnService.retrieveCurrentTurn()).build();
	}

}
