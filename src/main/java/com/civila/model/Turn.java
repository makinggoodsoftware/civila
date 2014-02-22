package com.civila.model;

import com.civila.model.order.OrderPlaceholder;

import java.util.ArrayList;
import java.util.List;

public class Turn {
	private List<OrderPlaceholder> possibleOrders = new ArrayList<>();
	private List<Quest> quests = new ArrayList<>();
	private int daysOfAdventure = 0;

	public Turn() {
	}

	public Turn(Quest quest) {
		possibleOrders.add(new OrderPlaceholder());
		quests.add(quest);
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

	public int getDaysOfAdventure() {
		return daysOfAdventure;
	}

	public void setDaysOfAdventure(int daysOfAdventure) {
		this.daysOfAdventure = daysOfAdventure;
	}
}
