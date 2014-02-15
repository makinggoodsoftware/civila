package com.civila.model;

public class Civiblock {
	private Coordinates coordinates;
	private CiviblockStates state;
	private Territory territory;
	private Persona persona;

	public static Civiblock empty(Coordinates coordinate){
		return new Civiblock(CiviblockStates.UNKNOWN, null, null, coordinate);
	}

	public Civiblock() {
	}

	public Civiblock(CiviblockStates state, Territory territory, Persona persona, Coordinates coordinates) {
		this.state = state;
		this.territory = territory;
		this.persona = persona;
		this.coordinates = coordinates;
	}

	public boolean contains(Persona persona) {
		return this.persona.equals(persona);
	}

	public void removePersona(Persona personaToMove) {
		this.persona = null;
	}

	public void addPersona(Persona persona) {
		this.persona = persona;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public CiviblockStates getState() {
		return state;
	}

	public void setState(CiviblockStates state) {
		this.state = state;
	}

	public Territory getTerritory() {
		return territory;
	}

	public void setTerritory(Territory territory) {
		this.territory = territory;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean isUnknown() {
		return state == CiviblockStates.UNKNOWN;
	}
}
