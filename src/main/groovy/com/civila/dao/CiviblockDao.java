package com.civila.dao;

import com.civila.model.*;
import com.civila.model.grid.GridCell;

import java.util.Map;

public class CiviblockDao {
	private final Map<Coordinates, GridCell> data;

	public CiviblockDao(Map<Coordinates, GridCell> data) {
		this.data = data;
	}

	public GridCell retrieve(int x, int y) {
		return this.data.get(new Coordinates(x, y));
	}

	public void add(GridCell newBlock) {
		data.put(newBlock.getCoordinates(), newBlock);
	}
}
