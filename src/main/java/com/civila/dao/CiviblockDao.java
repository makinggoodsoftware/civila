package com.civila.dao;

import com.civila.model.*;

import java.util.Map;

public class CiviblockDao {
	private final Map<Coordinates, Civiblock> data;

	public CiviblockDao(Map<Coordinates, Civiblock> data) {
		this.data = data;
	}

	public Civiblock retrieve(int x, int y) {
		Coordinates toFind = new Coordinates(x, y);
		return this.data.get(toFind);
	}

	public void add(Civiblock newBlock) {
		data.put(newBlock.getCoordinates(), newBlock);
	}
}
