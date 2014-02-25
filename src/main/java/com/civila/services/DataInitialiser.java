package com.civila.services;

import com.civila.model.*;
import com.civila.model.grid.Grid;
import com.civila.model.grid.GridContentProvider;
import com.civila.model.resource.Information;
import com.civila.model.resource.Interactable;
import com.civila.model.resource.Merchant;
import com.civila.model.resource.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataInitialiser {
	public Map<Coordinates, Civiblock> initialiseData() {
		Map<Coordinates, Civiblock> data = new HashMap<>();
		Coordinates initialLocation = new Coordinates(0, 0);
		Grid<Resource> resources = new Grid<>(5, 5, new GridContentProvider<Resource>() {
			@Override
			public Resource forCoordinates(int x, int y) {
				List<Interactable> interactables = new ArrayList<>();
				interactables.add(new Interactable(1, "Learn more about goblins!"));
				if (x==0 && y ==0) return new Merchant("Basic weapons merchant", new ArrayList<Interactable>());
				if (x==0 && y ==1) return new Information("Goblin expert", interactables);
				return null;
			}
		});
		data.put(
				initialLocation,
				new Civiblock(
						CiviblockStates.OCCUPIED,
						new Territory(TerritoryType.FARMS, resources),
						new Persona("Jon doe"),
						initialLocation
				)
		);
		return data;
	}
}
