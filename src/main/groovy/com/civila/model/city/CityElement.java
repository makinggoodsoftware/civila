package com.civila.model.city;

import java.util.List;

public interface CityElement {
	public boolean isSingleItem();
	public List<PlacedCityElement> getChildren();
}
