package com.civila.services.internal;

import com.civila.model.*;
import com.civila.services.NavigationService;

public class InternalNavigationService implements NavigationService{
	private final InternalCiviblockService internalCiviblockService;
	private final WorldCreator worldCreator;

	public InternalNavigationService(WorldCreator worldCreator, InternalCiviblockService internalCiviblockService) {
		this.worldCreator = worldCreator;
		this.internalCiviblockService = internalCiviblockService;
	}

	@Override
	public void navigate(NavigationRequest navigationRequest) {
		Coordinates from = navigationRequest.getFrom();
		Coordinates to = navigationRequest.getTo();
		Persona personaToMove = navigationRequest.getPersona();

		Civiblock fromBlock = this.internalCiviblockService.produceCiviblock(from);
		Civiblock toBlock = this.internalCiviblockService.produceCiviblock(to);

		if (toBlock.isUnknown()){
			toBlock = this.worldCreator.createBlock (to);
			this.internalCiviblockService.expand(toBlock);
		}

		fromBlock.removePersona(personaToMove);
		fromBlock.setState(CiviblockStates.VISITED);
		toBlock.addPersona(personaToMove);
		toBlock.setState(CiviblockStates.OCCUPIED);
	}
}
