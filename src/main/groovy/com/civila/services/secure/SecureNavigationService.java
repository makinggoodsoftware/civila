package com.civila.services.secure;

import com.civila.model.order.NavigationRequest;
import com.civila.services.NavigationService;
import com.civila.services.internal.InternalNavigationService;
import com.civila.services.secure.asserts.NavigationAsserts;

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
			() -> internalNavigationService.navigate (navigationRequest)
		);
	}

}
