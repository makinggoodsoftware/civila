package com.civila.services.secure.asserts;

import com.civila.aux.assertion.AssertException;
import com.civila.aux.assertion.Assertion;
import com.civila.aux.assertion.AssertionRunner;
import com.civila.model.Coordinates;
import com.civila.model.NavigationRequest;
import com.civila.model.Persona;

public class NavigationAsserts {
	private final CiviblockAsserts civiblockAsserts;
	private final AssertionRunner assertionRunner;

	public NavigationAsserts(CiviblockAsserts civiblockAsserts, AssertionRunner assertionRunner) {
		this.civiblockAsserts = civiblockAsserts;
		this.assertionRunner = assertionRunner;
	}

	public AssertionRunner.AssertContinuation assertNavigationIsLegal(final NavigationRequest navigationRequest) throws AssertException {
		final Coordinates from = navigationRequest.getFrom();
		final Persona persona = navigationRequest.getPersona();

		return assertionRunner.run(new Assertion() {
			@Override
			public boolean condition() {
				return civiblockAsserts.assertCoordinatesContainsPersona (from, persona).isSatisfied();
			}

			@Override
			public String assertionErrorDescription() {
				return "Illegal navigation request!";
			}
		});
	}

}
