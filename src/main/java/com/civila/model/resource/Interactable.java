package com.civila.model.resource;

public class Interactable {
	private int costInDays;
	private String interactionDescription;

	public Interactable(int costInDays, String interactionDescription) {
		this.costInDays = costInDays;
		this.interactionDescription = interactionDescription;
	}

	public int getCostInDays() {
		return costInDays;
	}

	public void setCostInDays(int costInDays) {
		this.costInDays = costInDays;
	}

	public String getInteractionDescription() {
		return interactionDescription;
	}

	public void setInteractionDescription(String interactionDescription) {
		this.interactionDescription = interactionDescription;
	}
}
