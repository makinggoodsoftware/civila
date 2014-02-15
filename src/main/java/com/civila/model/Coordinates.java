package com.civila.model;

public class Coordinates {
	private int x;
	private int y;

	public Coordinates() {
	}

	public static Coordinates coordinatesFrom(int x, int y) {
		return new Coordinates(x, y);
	}

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Coordinates)) return false;

		Coordinates that = (Coordinates) o;

		if (x != that.x) return false;
		return y == that.y;

	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}
}
