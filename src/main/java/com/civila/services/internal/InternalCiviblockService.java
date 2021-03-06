package com.civila.services.internal;

import com.civila.dao.CiviblockDao;
import com.civila.model.Civiblock;
import com.civila.model.Coordinates;
import com.civila.model.grid.Grid;
import com.civila.model.grid.GridContentProvider;
import com.civila.services.CiviblockService;

public class InternalCiviblockService implements CiviblockService {
	private final CiviblockDao civiblockDao;

	public InternalCiviblockService(CiviblockDao civiblockDao) {
		this.civiblockDao = civiblockDao;
	}

	@Override
	public Grid<Civiblock> retrieveGrid(final int delta1_x, final int delta1_y, int delta2_x, int delta2_y) {
		int numOfRows = Math.abs(delta2_y - delta1_y) + 1;
		int numOfCols = Math.abs(delta2_x - delta1_x) + 1;

		return new Grid<>(numOfRows, numOfCols, new GridContentProvider<Civiblock>() {
			@Override
			public Civiblock forCoordinates(int x, int y) {
				int realCoordinateX = delta1_x + x;
				int realCoordinateY = -(delta1_y + y);
				return produceCiviblock(new Coordinates(realCoordinateX, realCoordinateY));
			}
		});
	}

	public Civiblock produceCiviblock(Coordinates coordinates) {
		Civiblock found = civiblockDao.retrieve(coordinates.getX(), coordinates.getY());
		return (found == null) ? Civiblock.empty(new Coordinates(coordinates.getX(), coordinates.getY())) : found;
	}

	public void expand(Civiblock newBlock) {
		this.civiblockDao.add(newBlock);
	}
}
