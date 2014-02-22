package com.civila.model.resource;

import java.util.List;

public class Merchant extends BaseResource implements Resource {
	public Merchant() {
		super(null,  null);
	}

	public Merchant(String description, List<Interactable> interactables) {
		super(description, interactables);
	}

	@Override
	public ResourceType getResourceType() {
		return ResourceType.MERCHANT;
	}
}
