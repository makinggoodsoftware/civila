package com.civila.model;

import java.util.ArrayList;
import java.util.List;

public class Turn {
	private List<OrderPlaceholder> possibleOrders = new ArrayList<>();

	public Turn() {
		possibleOrders.add(new OrderPlaceholder());
	}

	public List<OrderPlaceholder> getPossibleOrders() {
		return possibleOrders;
	}

	public void setPossibleOrders(List<OrderPlaceholder> possibleOrders) {
		this.possibleOrders = possibleOrders;
	}
}
