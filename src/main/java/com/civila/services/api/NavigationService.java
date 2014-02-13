package com.civila.services.api;

import com.civila.aux.assertion.AssertResultProcessor;
import com.civila.model.NavigationRequest;
import com.civila.services.NavigationServiceAsserts;

public class NavigationService {

	private final NavigationServiceAsserts navigationServiceAsserts;

	public NavigationService(NavigationServiceAsserts navigationServiceAsserts) {
		this.navigationServiceAsserts = navigationServiceAsserts;
	}

	public boolean navigate(NavigationRequest navigationRequest) {
		final boolean[] result = new boolean[1];
		navigationServiceAsserts.assertNavigationIsLegal(navigationRequest).then(
			new AssertResultProcessor() {
				@Override
				public void onAssertSuccessful() {
					result[0] = true;
				}

				@Override
				public void onAssertError() {
					result[0] = false;
				}
			}
		);
		return result[0];
	}

}
