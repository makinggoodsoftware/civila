package com.civila.services.secure;

import com.civila.model.NavigationRequest;
import com.civila.model.Turn;
import com.civila.services.CommandsService;

public class SecureCommandsService implements CommandsService {
	private final SecureNavigationService secureNavigationService;

	public SecureCommandsService(SecureNavigationService secureNavigationService) {
		this.secureNavigationService = secureNavigationService;
	}

	@Override
	public void endTurn(Turn turn) {
		secureNavigationService.navigate((NavigationRequest) turn.getPossibleOrders().get(0).getDefinition());
	}
}
