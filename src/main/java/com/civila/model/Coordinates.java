package com.civila.model;

public class Coordinates {
	public final int x;
	public final int y;

	public static Coordinates coordinatesFrom(int x, int y) {
		return new Coordinates(x, y);
	}

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
