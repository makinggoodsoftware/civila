function Grid(numRows, numCols) {
    this.rows = [];
    this.numRows = numRows;
    this.numCols = numCols;

    for (var i = 1; i <= numRows; i++) {
        this.rows[i - 1] = new Row(numCols);
    }
}

Grid.prototype.getLocation = function (row, col) {
    return this.rows[row - 1].getLocation(col);
};

function Row(numCols) {
    this.locations = [];


    for (var i = 1; i <= numCols; i++) {
        this.locations[i - 1] = new Location();
    }
}

Row.prototype.getLocation = function (col) {
    return this.locations [col - 1];
};

function Location() {
    //noinspection JSUnusedGlobalSymbols
    this.territory = {};
    //noinspection JSUnusedGlobalSymbols
    this.population = {size:1};
}

Location.prototype.setTerritory = function (territory) {
    //noinspection JSUnusedGlobalSymbols
    this.territory = territory;
};
