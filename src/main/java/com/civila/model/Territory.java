package com.civila.model;

public class Territory {
	private TerritoryType type;

	public Territory() {
	}

	public Territory(TerritoryType type) {
		this.type = type;
	}

	public TerritoryType getType() {
		return type;
	}

	public void setType(TerritoryType type) {
		this.type = type;
	}
}
