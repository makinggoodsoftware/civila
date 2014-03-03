package com.civila.services.secure;

import com.civila.aux.assertion.AssertResultProcessor;
import com.civila.model.order.NavigationRequest;
import com.civila.services.NavigationService;
import com.civila.services.secure.asserts.NavigationAsserts;
import com.civila.services.internal.InternalNavigationService;

public class SecureNavigationService implements NavigationService {
	private final InternalNavigationService internalNavigationService;
	private final NavigationAsserts navigationAsserts;

	public SecureNavigationService(InternalNavigationService internalNavigationService, NavigationAsserts navigationAsserts) {
		this.internalNavigationService = internalNavigationService;
		this.navigationAsserts = navigationAsserts;
	}

	@Override
	public void navigate(final NavigationRequest navigationRequest) {
		navigationAsserts.assertNavigationIsLegal(navigationRequest).then(
			new AssertResultProcessor() {
				@Override
				public void execute() {
					internalNavigationService.navigate (navigationRequest);
				}
			}
		);
	}

}
