package com.civila.controllers;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("knowledge")
public class KnowledgeDaoController {

	@GET
	@Path("get")
	@Produces("application/json")
	public Response get(){
		return Response.status(200).entity(new Knowledge()).build();
	}

	private static class Knowledge {
		public final String data;

		private Knowledge() {
			this.data = "hello world";
		}

	}
}
