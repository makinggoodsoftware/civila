package com.civila.model.twoD

class Grid<T> {
    int columnSize = 0
    int elements = 0
    List<List<T>> gridData
    Surface area

    static def <T> Grid<T> from(List<List<T>> rawData) {
        Grid<T> grid = empty()
        rawData.each {List<T> row ->
            grid.addRow {row}
        }
        grid
    }

    static def <T> Grid<T> empty() {
        new Grid(gridData: [[]])
    }

    static def <T> Grid<T> singleElement(T element) {
        new Grid(gridData: [[element]])
    }

    T getContent (TwoDPoint twoDPoint){
        TwoDPoint yReversed = area.reverseY (twoDPoint)
        gridData[yReversed.y][yReversed.x]
    }

    def addRow(Closure<List<T>> rowFn) {
        List<T> row = rowFn ()
        def incomingColumnSize = row.size()
        if (elements == 0){
            this.columnSize = incomingColumnSize
            this.gridData = []
            area = new Surface(height: 0, width: columnSize)
        }else if (incomingColumnSize != this.columnSize) {
            throw new IllegalArgumentException("Trying to build an irregular grid, the row ${row} doesn't match previous inserted grid, expected dimension: ${this.columnSize}")
        }
        area = area.incrementHeightBy (1)
        elements += incomingColumnSize
        gridData << row
    }

    def <Z> Grid<Z> transform (Closure <Z> transformIntoZClosure){
        from(gridData.collect {List<T> row->
            row.collect {T column->
                transformIntoZClosure (column)
            }
        })
    }

    List<List<T>> getAsRawData() {
        gridData
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Grid)) return false

        Grid grid1 = (Grid) o

        if (gridData != grid1.gridData) return false

        return true
    }


    int hashCode() {
        return gridData.hashCode()
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("columnSize", columnSize)
                .add("elements", elements)
                .add("grid", gridData)
                .toString();
    }

    Surface getArea() {
       area
    }
}
