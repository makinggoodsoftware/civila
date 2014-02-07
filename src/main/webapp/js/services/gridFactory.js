function GridFactory (LocationDao){
    this.locationDao = LocationDao;
}

GridFactory.prototype.createNewGrid = function (){
    var grid = new Grid(3, 3);
    return this.populate (grid);
};

GridFactory.prototype.populate = function (grid) {
    for (var row = 1; row <= grid.numRows; row++) {
        for (var column = 1; column <= grid.numCols; column++) {
            var location = grid.getLocation(new Coordinates(row, column));

            var configItem = this.locationDao.findLocation(row, column);
            if (!configItem) continue;

            if (configItem.territory)  location.territory  = configItem.territory;
            if (configItem.persona) location.persona = configItem.persona;
        }
    }

    return grid;
};