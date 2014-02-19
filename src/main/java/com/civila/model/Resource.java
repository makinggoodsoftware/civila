package com.civila.model;

public class Resource {
	private ResourceType resourceType;

	public Resource() {
	}

	public Resource(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}
}
