package com.civila.model.resource;

public abstract class BaseResource {
	protected String description;

	protected BaseResource(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
