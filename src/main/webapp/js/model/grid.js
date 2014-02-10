function Coordinates (x, y){
    this.x = x;
    this.y = y;
}

Coordinates.prototype.plus = function (direction){
    switch (direction){
        case Directions.NORTH: return new Coordinates (this.x, this.y - 1);
        case Directions.SOUTH: return new Coordinates (this.x, this.y + 1);
        case Directions.EAST: return new Coordinates (this.x + 1, this.y);
        case Directions.WEST: return new Coordinates (this.x - 1, this.y);
    }
    throw new Error("Invalid direction -> " + direction);
};

function Grid(numRows, numCols) {
    this.rows = [];

    for (var i = 1; i <= numRows; i++) {
        this.rows[i - 1] = new Row(numCols);
    }
}

Grid.prototype.getCell = function (coordinates) {
    return this.rows[coordinates.y - 1].getCell(coordinates.x);
};

Grid.prototype.findCoordinates = function (cellToFind) {
    for (var i = 0; i < this.rows.length; i++) {
        var row = this.rows[i];
        for (var j = 0; j < row.cells.length; j++) {
            var cell = row.cells[j];
            if (cell == cellToFind){
                return new Coordinates (j+1, i+1);
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
