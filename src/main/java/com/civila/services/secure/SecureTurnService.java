package com.civila.services.secure;

import com.civila.model.Turn;

public class SecureTurnService implements com.civila.services.TurnService {
	@Override
	public Turn retrieveCurrentTurn() {
		return new Turn();
	}
}
