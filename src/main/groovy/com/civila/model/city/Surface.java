package com.civila.model.city;

import com.civila.model.Coordinates;

public class Surface {
	private int width;
	private int height;

	public Coordinates findAnchorPoint(Coordinates from) {
		int offset = 1;
		int halfWidth = (width / 2) + offset;
		int halfHeight = (height / 2) + offset;
		return new Coordinates(from.getX() - halfWidth, from.getY() - halfHeight);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
