package com.civila.model;

import java.util.List;

public class Turn {
	private List<NavigationRequest> navigationRequests;

	public Turn() {
	}

	public List<NavigationRequest> getNavigationRequests() {
		return navigationRequests;
	}

	public void setNavigationRequests(List<NavigationRequest> navigationRequests) {
		this.navigationRequests = navigationRequests;
	}
}
