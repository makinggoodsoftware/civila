package com.civila.model.city;

import java.util.List;

public class City {
	private String name;
	private Surface influence;
	private PlacedCityElement walled;
	private List<PlacedCityElement> unwalled;

	public String getName() {
		return name;
	}

	public Surface getInfluence() {
		return influence;
	}

	public PlacedCityElement getWalled() {
		return walled;
	}

	public List<PlacedCityElement> getUnwalled() {
		return unwalled;
	}
}
