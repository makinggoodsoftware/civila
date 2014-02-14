package com.civila.services.asserts;

import com.civila.aux.assertion.AssertResult;
import com.civila.aux.assertion.Assertion;
import com.civila.aux.assertion.AssertionRunner;
import com.civila.model.Coordinates;
import com.civila.model.Persona;
import com.civila.services.api.CiviblockService;

public class CiviblockAsserts {
	private final CiviblockService civiblockService;
	private final AssertionRunner assertionRunner;

	public CiviblockAsserts(CiviblockService civiblockService, AssertionRunner assertionRunner) {
		this.civiblockService = civiblockService;
		this.assertionRunner = assertionRunner;
	}

	public AssertResult assertCoordinatesContainsPersona(final Coordinates from, final Persona persona) {
		return assertionRunner.run(new Assertion(){
			@Override
			public boolean condition() {
				return civiblockService.produceCiviblock(from).contains(persona);
			}

			@Override
			public String assertionErrorDescription() {
				return "Coordinates don't contain persona";
			}
		});
	}
}
