package com.civila.services.internal;

import com.civila.model.*;
import com.civila.model.grid.Grid;
import com.civila.model.grid.GridContentProvider;
import com.civila.model.resource.Resource;

public class WorldCreator {
	public Civiblock createBlock(Coordinates to) {
		Grid<Resource> resources = new Grid<>(5, 5, new GridContentProvider<Resource>() {
			@Override
			public Resource forCoordinates(int x, int y) {
				return null;
			}
		});
		return new Civiblock(CiviblockStates.VISITED, new Territory(TerritoryType.SWAMP, resources), null, to);
	}
}
