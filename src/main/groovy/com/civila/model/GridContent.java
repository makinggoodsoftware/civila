package com.civila.model;

import com.civila.model.resource.Resource;

public class GridContent {
	private TerritoryType type;
	private Resource resource;

	public GridContent() {
	}

	public GridContent(TerritoryType type, Resource resource) {
		this.type = type;
		this.resource = resource;
	}

	public TerritoryType getType() {
		return type;
	}

	public void setType(TerritoryType type) {
		this.type = type;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResources(Resource resource) {
		this.resource = resource;
	}
}
