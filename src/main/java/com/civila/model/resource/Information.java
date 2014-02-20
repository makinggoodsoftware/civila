package com.civila.model.resource;

public class Information extends BaseResource implements Resource {

	public Information() {
		super(null);
	}

	public Information(String description) {
		super(description);
	}

	@Override
	public ResourceType getResourceType() {
		return ResourceType.INFORMATION;
	}

}
