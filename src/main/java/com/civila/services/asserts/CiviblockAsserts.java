package com.civila.services.asserts;

import com.civila.aux.assertion.AssertResult;
import com.civila.model.Coordinates;
import com.civila.model.Persona;
import com.civila.services.api.CiviblockService;

public class CiviblockAsserts {
	private final CiviblockService civiblockService;

	public CiviblockAsserts(CiviblockService civiblockService) {
		this.civiblockService = civiblockService;
	}

	public AssertResult assertCoordinatesContainsPersona(Coordinates from, Persona persona) {
		if (civiblockService.produceCiviblock(from).contains(persona)) {
			return new AssertResult(true, "");
		}else{
			return new AssertResult(false, "Coordinates don't contain person");
		}
	}
}
