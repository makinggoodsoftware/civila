package com.civila.services.internal;

import com.civila.model.Coordinates;
import com.civila.model.city.Building;
import com.civila.model.city.City;
import com.civila.model.city.CityElement;
import com.civila.model.city.PlacedCityElement;
import com.civila.model.grid.GridCell;
import com.google.common.collect.Maps;

import java.util.Map;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Lists.newArrayList;

public class DataInitialiser {
	private final CityFactory cityFactory;

	public DataInitialiser(CityFactory cityFactory) {
		this.cityFactory = cityFactory;
	}

	public Map<Coordinates, GridCell> initialiseData() {
		Map<Coordinates, GridCell> initialisedData = Maps.newHashMap();
//		City alberta = cityFactory.alberta();
//		Coordinates topLeftAnchorPoint = alberta.getInfluence().findAnchorPoint(new Coordinates(0, 0));
//		Map<Coordinates, Building> cityElementsMap = mapCityIntoCoordinates(alberta, topLeftAnchorPoint);
//		for (Coordinates coordinates : cityElementsMap.keySet()) {
//			Building cityElement = cityElementsMap.get(coordinates);
//			initialisedData.put(coordinates, new GridCell(CiviblockStates.UNKNOWN, new GridContent(TerritoryType.FARMS, cityElement), null, coordinates));
//		}
		return initialisedData;
	}

	private Map<Coordinates, Building> mapCityIntoCoordinates(City city, Coordinates initialOffset){
		Map<Coordinates, Building> mappedCity = Maps.newHashMap();
//		for (int x=0; x<city.getInfluence().getWidth(); x++){
//			for (int y=0; y<city.getInfluence().getHeight(); y++){
//				mappedCity.put(new Coordinates(x, y), null);
//			}
//		}
		Iterable<PlacedCityElement> allCityBlocks = concat(city.getUnwalled(), newArrayList(city.getWalled()));
		for (PlacedCityElement placedCityElement : allCityBlocks) {
			recursivelyMap(mappedCity, placedCityElement, initialOffset);
		}
		return mappedCity;
	}

	private void recursivelyMap(Map<Coordinates, Building> mappedCity, PlacedCityElement placedCityElement, Coordinates parentOffset) {
		CityElement cityElement = placedCityElement.getCityElement();

		if (cityElement.isSingleItem()){
			int x = placedCityElement.getRelativeToParentAnchorPoint().getX() + parentOffset.getX();
			int y = placedCityElement.getRelativeToParentAnchorPoint().getY() + parentOffset.getY();
			mappedCity.put(new Coordinates(x, y), (Building) cityElement);
		}else{
			for (PlacedCityElement child : cityElement.getChildren()) {
				recursivelyMap(mappedCity, child, placedCityElement.getRelativeToParentAnchorPoint());
			}
		}
	}

}
