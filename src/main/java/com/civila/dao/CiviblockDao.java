package com.civila.dao;

import com.civila.model.*;

public class CiviblockDao {
	public Civiblock retrieve(int x, int y) {
		if (x==0 && y==0){
			return new Civiblock(CiviblockStates.OCCUPIED, new Territory(TerritoryType.FARMS), new Persona("Jon doe"));
		}
		return null;
	}
}
