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
				public String onAssertError() {
					return "Navigation request is illegal!";
				}
			}
		);
		return result[0];
	}

}
