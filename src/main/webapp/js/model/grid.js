function Coordinates (x, y){
    this.x = x;
    this.y = y;
}

Coordinates.prototype.north = function (){
    return new Coordinates (this.x, this.y + 1);
};

function Grid(numRows, numCols) {
    this.rows = [];

    for (var i = 1; i <= numRows; i++) {
        this.rows[i - 1] = new Row(numCols);
    }
}

Grid.prototype.getCell = function (coordinates) {
    return this.rows[coordinates.x - 1].getCell(coordinates.y);
};

Grid.prototype.findCoordinates = function (cellToFind) {
    for (var i = 0; i < this.rows.length; i++) {
        var row = this.rows[i];
        for (var j = 0; j < row.cells.length; j++) {
            var cell = row.cells[j];
            if (cell == cellToFind){
                return new Coordinates (i+1, j+1);
            }
        }
    }
    throw new Error("Can't find the coordinates for the cell" + JSON.stringify(cellToFind));
};

function Row(numCols) {
    this.cells = [];


    for (var i = 1; i <= numCols; i++) {
        this.cells[i - 1] = new Cell(TerritoryTypes.UNKNOWN, null);
    }
}

Row.prototype.getCell = function (y) {
    return this.cells [y - 1];
};
