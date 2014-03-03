package com.civila.model.resource;

import java.util.List;

public abstract class BaseResource implements Resource{
	protected String description;
	private List<Interactable> interactables;

	protected BaseResource(String description, List<Interactable> interactables) {
		this.description = description;
		this.interactables = interactables;
	}

	@Override
	public final String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public final List<Interactable> getInteractables() {
		return interactables;
	}

	public void setInteractables(List<Interactable> interactables) {
		this.interactables = interactables;
	}
}
