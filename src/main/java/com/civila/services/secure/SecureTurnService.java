package com.civila.services.secure;

import com.civila.model.Quest;
import com.civila.model.Turn;

public class SecureTurnService implements com.civila.services.TurnService {
	@Override
	public Turn retrieveCurrentTurn() {
		return new Turn(
			new Quest(
				"In the beggining",
				"People is unhappy about their security. The number of attacks from the goblins has increased",
				"Make the people feel more secure",
				60
			)
		);
	}
}
