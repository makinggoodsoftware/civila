package com.civila.model.grid;


import java.util.ArrayList;
import java.util.List;

public class Grid<T> {
	public final List<Row> rows = new ArrayList<>();

	public Grid(int numOfRows, int numOfCols, GridContentProvider<T> gridContentProvider) {
		for (int i = 0; i < numOfRows; i++){
			rows.add(new Row(i, numOfCols, gridContentProvider));
		}
	}

	public static class Row<T> {
		private final int rowIndex;
		private final GridContentProvider<T> gridContentProvider;
		public final List<T> columns = new ArrayList<>();

		public Row(int rowIndex, int numOfCols, GridContentProvider<T> gridContentProvider) {
			this.rowIndex = rowIndex;
			this.gridContentProvider = gridContentProvider;
			for (int i = 0; i < numOfCols; i++){
				columns.add(this.gridContentProvider.forCoordinates(rowIndex, i));
			}
		}
	}
}