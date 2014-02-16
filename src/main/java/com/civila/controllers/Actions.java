package com.civila.controllers;

import com.civila.aux.assertion.AssertException;
import com.civila.model.Turn;
import com.civila.services.secure.SecureCommandsService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("actions")
public class Actions {
	private final SecureCommandsService commandsService;

	public Actions(SecureCommandsService commandsService) {
		this.commandsService = commandsService;
	}

	@POST
	@Path("submitTurn")
	@Produces("application/json")
	public Response navigate(Turn turn){
		try {
			commandsService.endTurn(turn);
			return Response.status(200).entity(true).build();
		} catch (AssertException e) {
			return Response.status(500).entity(e).build();
		}
	}
}
