package com.civila.services;

import com.civila.model.Civiblock;
import com.civila.model.grid.Grid;

public interface CiviblockService {
	Grid<Civiblock> retrieveGrid(int delta1_x, int delta1_y, int delta2_x, int delta2_y);
}
