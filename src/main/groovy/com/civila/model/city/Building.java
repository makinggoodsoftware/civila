package com.civila.model.city;


import com.civila.model.resource.Interactable;
import com.civila.model.resource.Resource;
import com.civila.model.resource.ResourceType;
import com.google.common.collect.Lists;

import java.util.List;

public class Building implements CityElement, Resource {
    private BuildingType type;
	private String description;
	private List<Interactable> interactables;

	@Override
	public boolean isSingleItem() {
		return true;
	}

	@Override
	public List<PlacedCityElement> getChildren() {
		return Lists.newArrayList();
	}

	@Override
	public ResourceType getResourceType() {
		return ResourceType.CITY;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public List<Interactable> getInteractables() {
		return interactables;
	}
}
