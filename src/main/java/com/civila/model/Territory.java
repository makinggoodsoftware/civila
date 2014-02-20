package com.civila.model;

import com.civila.model.grid.Grid;
import com.civila.model.resource.Resource;

public class Territory {
	private TerritoryType type;
	private Grid<Resource> resources;

	public Territory() {
	}

	public Territory(TerritoryType type, Grid<Resource> resources) {
		this.type = type;
		this.resources = resources;
	}

	public TerritoryType getType() {
		return type;
	}

	public void setType(TerritoryType type) {
		this.type = type;
	}

	public Grid<Resource> getResources() {
		return resources;
	}

	public void setResources(Grid<Resource> resources) {
		this.resources = resources;
	}
}
