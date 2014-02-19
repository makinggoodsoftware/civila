package com.civila.model;

import java.util.List;

public class Territory {
	private TerritoryType type;
	private List<Resource> resources;

	public Territory() {
	}

	public Territory(TerritoryType type, List<Resource> resources) {
		this.type = type;
		this.resources = resources;
	}

	public TerritoryType getType() {
		return type;
	}

	public void setType(TerritoryType type) {
		this.type = type;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
}
