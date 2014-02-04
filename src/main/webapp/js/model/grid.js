function Grid(numRows, numCols) {
    this.rows = [];
    this.numRows = numRows;
    this.numCols = numCols;

    for (var i = 1; i <= numRows; i++) {
        this.rows[i - 1] = new Row(numCols);
    }
}

Grid.prototype.getCell = function (row, col) {
    return this.rows[row - 1].getCell(col);
};

function Row(numCols) {
    this.cells = [];


    for (var i = 1; i <= numCols; i++) {
        this.cells[i - 1] = new Cell();
    }
}

Row.prototype.getCell = function (col) {
    return this.cells [col - 1];
};

function Cell() {
}

Cell.prototype.setTerritory = function (territory) {
    //noinspection JSUnusedGlobalSymbols
    this.territory = territory;
};
