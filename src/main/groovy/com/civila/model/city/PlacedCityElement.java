package com.civila.model.city;

import com.civila.model.Coordinates;

public class PlacedCityElement {
	private CityElement cityElement;
	private Coordinates relativeToParentAnchorPoint;

	public CityElement getCityElement() {
		return cityElement;
	}

	public Coordinates getRelativeToParentAnchorPoint() {
		return relativeToParentAnchorPoint;
	}
}
