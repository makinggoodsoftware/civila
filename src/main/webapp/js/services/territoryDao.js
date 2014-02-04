function TerritoryDao(config) {
    this.config = config;
}

TerritoryDao.prototype.populate = function (grid) {
    for (var row = 1; row <= grid.numRows; row++) {
        for (var column = 1; column <= grid.numCols; column++) {
            grid.getLocation(row, column).setTerritory(this.findTerritory(row, column));
        }
    }
};

TerritoryDao.prototype.findTerritory = function (row, column) {
    if (this.config[row] && this.config[row][column]) {
        return this.config[row][column];
    }
    return new Territory("unknown")
};
