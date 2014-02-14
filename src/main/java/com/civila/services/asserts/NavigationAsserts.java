package com.civila.services.asserts;

import com.civila.aux.assertion.AssertException;
import com.civila.aux.assertion.AssertResult;
import com.civila.aux.assertion.AssertResultProcessor;
import com.civila.model.Coordinates;
import com.civila.model.NavigationRequest;
import com.civila.model.Persona;

public class NavigationAsserts {
	private final CiviblockAsserts civiblockAsserts;

	public NavigationAsserts(CiviblockAsserts civiblockAsserts) {
		this.civiblockAsserts = civiblockAsserts;
	}

	public AssertResult assertNavigationIsLegal(NavigationRequest navigationRequest) throws AssertException {
		final AssertResult[] assertResult = new AssertResult[1];
		Coordinates from = navigationRequest.getFrom();
		Persona persona = navigationRequest.getPersona();
		civiblockAsserts.assertCoordinatesContainsPersona (from, persona).then(
			new AssertResultProcessor() {
				@Override
				public void onAssertSuccessful() {
					assertResult[0] = new AssertResult(true, "");
				}

				@Override
				public String onAssertError() {
					return "Illegal navigation request!";
				}
			}
		);
		return assertResult[0];
	}

}
