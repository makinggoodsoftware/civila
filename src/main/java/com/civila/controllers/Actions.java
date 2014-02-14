package com.civila.controllers;

import com.civila.aux.assertion.AssertException;
import com.civila.model.NavigationRequest;
import com.civila.services.api.NavigationService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("actions")
public class Actions {
	private final NavigationService navigationService;

	public Actions(NavigationService navigationService) {
		this.navigationService = navigationService;
	}

	@POST
	@Path("navigate")
	@Produces("application/json")
	public Response navigate(NavigationRequest navigationRequest){
		try {
			return Response.status(200).entity(navigationService.navigate(navigationRequest)).build();
		} catch (AssertException e) {
			return Response.status(500).entity(e).build();
		}
	}
}
