function LocationDao(config) {
    this.config = config;
}

LocationDao.prototype.populate = function (grid) {
    for (var row = 1; row <= grid.numRows; row++) {
        for (var column = 1; column <= grid.numCols; column++) {
            var location = grid.getLocation(row, column);

            var configItem = this.findConfig(row, column);
            if (!configItem) continue;

            if (configItem.territory)  location.territory  = configItem.territory;
            if (configItem.population) location.population = configItem.population;
        }
    }
};

LocationDao.prototype.findConfig = function (row, column) {
    if (this.config[row] && this.config[row][column]) {
        return this.config[row][column];
    }
    return null;
};
