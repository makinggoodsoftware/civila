package com.civila.model.resource;

public class Merchant extends BaseResource implements Resource {
	public Merchant() {
		super(null);
	}

	public Merchant(String description) {
		super(description);
	}

	@Override
	public ResourceType getResourceType() {
		return ResourceType.MERCHANT;
	}
}
