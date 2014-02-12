package com.civila.model;

public class Civiblock {
	private static final Civiblock UNKNOWN = new Civiblock(CiviblockStates.UNKNOWN, null, null);
	public final CiviblockStates type;
	public final Territory territory;
	public final Persona persona;

	public static Civiblock empty (){
		return UNKNOWN;
	}

	public Civiblock(CiviblockStates type, Territory territory, Persona persona) {
		this.type = type;
		this.territory = territory;
		this.persona = persona;
	}
}
