package com.civila.model.grid;

import com.civila.model.CiviblockStates;
import com.civila.model.Coordinates;
import com.civila.model.GridContent;
import com.civila.model.Persona;

public class GridCell {
	private Coordinates coordinates;
	private CiviblockStates state;
	private GridContent gridContent;
	private Persona persona;

	public static GridCell empty(Coordinates coordinate){
		return new GridCell(CiviblockStates.UNKNOWN, null, null, coordinate);
	}

	public GridCell() {
	}

	public GridCell(CiviblockStates state, GridContent gridContent, Persona persona, Coordinates coordinates) {
		this.state = state;
		this.gridContent = gridContent;
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

	public GridContent getGridContent() {
		return gridContent;
	}

	public void setGridContent(GridContent gridContent) {
		this.gridContent = gridContent;
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
