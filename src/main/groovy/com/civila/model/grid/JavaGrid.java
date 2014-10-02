package com.civila.model.grid;


import java.util.ArrayList;
import java.util.List;

public class JavaGrid<T> {
	private final List<Row> rows = new ArrayList<>();

	public JavaGrid(int numOfRows, int numOfCols, GridContentProvider<T> gridContentProvider) {
		for (int y = 0; y < numOfRows; y++){
			rows.add(new Row<>(y, numOfCols, gridContentProvider));
		}
	}

	public static class Row<T> {
		private final GridContentProvider<T> gridContentProvider;
		public final List<T> columns = new ArrayList<>();

		public Row(int y, int numOfCols, GridContentProvider<T> gridContentProvider) {
			this.gridContentProvider = gridContentProvider;
			for (int x = 0; x < numOfCols; x++){
				columns.add(this.gridContentProvider.forCoordinates(x, y));
			}
		}
	}

	public List<Row> getRows() {
		return rows;
	}
}
