function Coordinates (x, y){
    this.x = x;
    this.y = y;
}

Coordinates.prototype.north = function (){
    return new Coordinates (this.x, this.y + 1);
};

function Grid(numRows, numCols) {
    this.rows = [];
    this.numRows = numRows;
    this.numCols = numCols;

    for (var i = 1; i <= numRows; i++) {
        this.rows[i - 1] = new Row(numCols);
    }
}

Grid.prototype.getLocation = function (coordinates) {
    return this.rows[coordinates.x - 1].getLocation(coordinates.y);
};

Grid.prototype.findCoordinates = function (locationToFind) {
    for (var i = 0; i < this.rows.length; i++) {
        var row = this.rows[i];
        for (var j = 0; j < row.locations.length; j++) {
            var location = row.locations[j];
            if (location == locationToFind){
                return new Coordinates (i+1, j+1);
            }
        }
    }
    throw new Error("Can't find the coordinates for location" + JSON.stringify(locationToFind));
};

function Row(numCols) {
    this.locations = [];


    for (var i = 1; i <= numCols; i++) {
        this.locations[i - 1] = new Location(TerritoryTypes.UNKNOWN, null);
    }
}

Row.prototype.getLocation = function (y) {
    return this.locations [y - 1];
};
