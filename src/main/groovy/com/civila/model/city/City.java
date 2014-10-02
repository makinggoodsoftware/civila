package com.civila.model.city;

import java.util.List;

public class City {
	private String name;
	private PlacedCityElement walled;
	private List<PlacedCityElement> unwalled;

	public String getName() {
		return name;
	}

	public PlacedCityElement getWalled() {
		return walled;
	}

	public List<PlacedCityElement> getUnwalled() {
		return unwalled;
	}
}
