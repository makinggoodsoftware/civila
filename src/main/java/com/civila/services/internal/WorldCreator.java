package com.civila.services.internal;

import com.civila.model.*;

import java.util.ArrayList;

public class WorldCreator {
	public Civiblock createBlock(Coordinates to) {
		return new Civiblock(CiviblockStates.VISITED, new Territory(TerritoryType.SWAMP, new ArrayList<Resource>()), null, to);
	}
}
