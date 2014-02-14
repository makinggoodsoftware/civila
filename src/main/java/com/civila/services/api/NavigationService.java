package com.civila.services.api;

import com.civila.aux.assertion.AssertException;
import com.civila.aux.assertion.AssertResultProcessor;
import com.civila.model.NavigationRequest;
import com.civila.services.asserts.NavigationAsserts;

public class NavigationService {

	private final NavigationAsserts navigationAsserts;

	public NavigationService(NavigationAsserts navigationAsserts) {
		this.navigationAsserts = navigationAsserts;
	}

	public boolean navigate(NavigationRequest navigationRequest) throws AssertException {
		final boolean[] result = new boolean[1];
		navigationAsserts.assertNavigationIsLegal(navigationRequest).then(
			new AssertResultProcessor() {
				@Override
				public void onAssertSuccessful() {
					result[0] = true;
				}

				@Override
				public void onAssertError(AssertException cause) throws AssertException {
					throw new AssertException("Illegal navigation request!", cause);
				}
			}
		);
		return result[0];
	}

}
