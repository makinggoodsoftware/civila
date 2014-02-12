package com.civila.services;

import com.civila.dao.CiviblockDao;
import com.civila.model.Civiblock;
import com.civila.model.grid.Grid;
import com.civila.model.grid.GridContentProvider;
import org.springframework.beans.factory.annotation.Autowired;

public class CiviblockService {
	private final CiviblockDao civiblockDao;

	@Autowired
	public CiviblockService(CiviblockDao civiblockDao) {
		this.civiblockDao = civiblockDao;
	}

	public Grid<Civiblock> retrieveGrid(final int delta1_x, final int delta1_y, int delta2_x, int delta2_y) {
		int numOfRows = Math.abs(delta2_y - delta1_y) + 1;
		int numOfCols = Math.abs(delta2_x - delta1_x) + 1;

		return new Grid<>(numOfRows, numOfCols, new GridContentProvider<Civiblock>() {
			@Override
			public Civiblock forCoordinates(int x, int y) {
				int realCoordinateX = delta1_x + x;
				int realCoordinateY = delta1_y + y;
				return produceCiviblock(realCoordinateX, realCoordinateY);
			}
		});
	}

	private Civiblock produceCiviblock(int x, int y) {
		Civiblock found = civiblockDao.retrieve(x, y);
		return (found == null) ? Civiblock.empty() : found;
	}
}
