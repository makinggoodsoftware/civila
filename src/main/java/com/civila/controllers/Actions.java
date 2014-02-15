package com.civila.controllers;

import com.civila.aux.assertion.AssertException;
import com.civila.model.NavigationRequest;
import com.civila.services.secure.SecureNavigationService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("actions")
public class Actions {
	private final SecureNavigationService secureNavigationService;

	public Actions(SecureNavigationService secureNavigationService) {
		this.secureNavigationService = secureNavigationService;
	}

	@POST
	@Path("navigate")
	@Produces("application/json")
	public Response navigate(NavigationRequest navigationRequest){
		try {
			secureNavigationService.navigate(navigationRequest);
			return Response.status(200).entity(true).build();
		} catch (AssertException e) {
			return Response.status(500).entity(e).build();
		}
	}
}
