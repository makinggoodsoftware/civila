package com.civila.services.internal;

import com.civila.model.CiviblockStates;
import com.civila.model.Coordinates;
import com.civila.model.GridContent;
import com.civila.model.TerritoryType;
import com.civila.model.grid.GridCell;

public class WorldCreator {
	public GridCell createBlock(Coordinates to) {
		return new GridCell(CiviblockStates.VISITED, new GridContent(TerritoryType.SWAMP, null), null, to);
	}
}
