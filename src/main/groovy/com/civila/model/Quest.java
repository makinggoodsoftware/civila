package com.civila.model;

public class Quest {
	private String name;
	private String shortDescription;
	private String objective;
	private int timeLimitInDays;

	public Quest() {
	}

	public Quest(String name, String shortDescription, String objective, int timeLimitInDays) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.objective = objective;
		this.timeLimitInDays = timeLimitInDays;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public int getTimeLimitInDays() {
		return timeLimitInDays;
	}

	public void setTimeLimitInDays(int timeLimitInDays) {
		this.timeLimitInDays = timeLimitInDays;
	}
}
