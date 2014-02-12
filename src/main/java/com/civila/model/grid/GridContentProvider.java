package com.civila.model.grid;

public interface GridContentProvider<T> {
	public T forCoordinates(int x, int y);
}
