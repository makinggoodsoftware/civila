package com.civila.services.internal;

import com.civila.model.*;

public class WorldCreator {
	public Civiblock createBlock(Coordinates to) {
		return new Civiblock(CiviblockStates.VISITED, new Territory(TerritoryType.SWAMP), null, to);
	}
}
