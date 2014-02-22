package com.civila.model.resource;

import java.util.List;

public class Information extends BaseResource implements Resource {

	public Information() {
		super(null, null);
	}

	public Information(String description, List<Interactable> interactables) {
		super(description, interactables);
	}

	@Override
	public ResourceType getResourceType() {
		return ResourceType.INFORMATION;
	}

}
