package com.civila.model;

import java.util.ArrayList;
import java.util.List;

public class Turn {
	private List<OrderPlaceholder> possibleOrders = new ArrayList<>();
	private List<Quest> quests = new ArrayList<>();

	public Turn() {
		possibleOrders.add(new OrderPlaceholder());
		quests.add(new Quest("Your dad sends you to kill 10 goblins"));
	}

	public List<OrderPlaceholder> getPossibleOrders() {
		return possibleOrders;
	}

	public void setPossibleOrders(List<OrderPlaceholder> possibleOrders) {
		this.possibleOrders = possibleOrders;
	}

	public List<Quest> getQuests() {
		return quests;
	}

	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}
}
