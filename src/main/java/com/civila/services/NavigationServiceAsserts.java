package com.civila.services;

import com.civila.aux.assertion.AssertResult;
import com.civila.model.NavigationRequest;

public class NavigationServiceAsserts {
	public AssertResult assertNavigationIsLegal(NavigationRequest navigationRequest) {
		return new AssertResult(true);
	}

}
