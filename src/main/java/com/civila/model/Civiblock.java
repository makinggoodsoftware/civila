package com.civila.model;

public class Civiblock {
	public final Coordinates coordinates;
	public final CiviblockStates state;
	public final Territory territory;
	public final Persona persona;

	public static Civiblock empty(Coordinates coordinate){
		return new Civiblock(CiviblockStates.UNKNOWN, null, null, coordinate);
	}

	public Civiblock(CiviblockStates state, Territory territory, Persona persona, Coordinates coordinates) {
		this.state = state;
		this.territory = territory;
		this.persona = persona;
		this.coordinates = coordinates;
	}
}
