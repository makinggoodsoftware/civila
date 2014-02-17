package com.civila.model;

public class NavigationRequest implements Order{
	private Coordinates from;
	private Coordinates to;
	private Persona persona;

	public NavigationRequest() {
	}

	public void setFrom(Coordinates from) {
		this.from = from;
	}

	public void setTo(Coordinates to) {
		this.to = to;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Coordinates getFrom() {
		return from;
	}

	public Coordinates getTo() {
		return to;
	}

	public Persona getPersona() {
		return persona;
	}
}
