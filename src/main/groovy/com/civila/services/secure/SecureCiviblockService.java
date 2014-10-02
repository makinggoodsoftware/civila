package com.civila.services.secure;

import com.civila.model.grid.GridCell;
import com.civila.model.grid.JavaGrid;
import com.civila.services.CiviblockService;
import com.civila.services.internal.InternalCiviblockService;

public class SecureCiviblockService implements CiviblockService{
	private final InternalCiviblockService internalCiviblockService;

	public SecureCiviblockService(InternalCiviblockService internalCiviblockService) {
		this.internalCiviblockService = internalCiviblockService;
	}

	@Override
	public JavaGrid<GridCell> retrieveGrid(int delta1_x, int delta1_y, int delta2_x, int delta2_y) {
		return internalCiviblockService.retrieveGrid(delta1_x, delta1_y, delta2_x, delta2_y);
	}
}
