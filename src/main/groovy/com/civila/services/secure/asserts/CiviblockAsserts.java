package com.civila.services.secure.asserts;

import com.civila.aux.assertion.Assertion;
import com.civila.aux.assertion.AssertionRunner;
import com.civila.model.Coordinates;
import com.civila.model.Persona;
import com.civila.services.internal.InternalCiviblockService;

public class CiviblockAsserts {
	private final InternalCiviblockService internalCiviblockService;
	private final AssertionRunner assertionRunner;

	public CiviblockAsserts(InternalCiviblockService internalCiviblockService, AssertionRunner assertionRunner) {
		this.internalCiviblockService = internalCiviblockService;
		this.assertionRunner = assertionRunner;
	}

	public AssertionRunner.AssertContinuation assertCoordinatesContainsPersona(final Coordinates from, final Persona persona) {
		return assertionRunner.run(new Assertion(){
			@Override
			public boolean condition() {
				return internalCiviblockService.produceCiviblock(from).contains(persona);
			}

			@Override
			public String assertionErrorDescription() {
				return "Coordinates don't contain persona";
			}
		});
	}
}
