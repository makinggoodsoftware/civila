package com.civila.model.city;

import java.util.List;

public class Division implements CityElement {
	private Faction controller;
	private List<PlacedCityElement> blocks;

	@Override
	public boolean isSingleItem() {
		return false;
	}

	@Override
	public List<PlacedCityElement> getChildren() {
		return blocks;
	}
}
