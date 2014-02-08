function TerritoryDao(config) {
    this.config = config;
}

TerritoryDao.prototype.retrieveTerritoryInfo = function (coordinates) {
    var configCoordinate = this.config.coordinates;
    if (configCoordinate.x == coordinates.x && configCoordinate.y == coordinates.y) {
        return this.config.territory;
    }
    return null;
};
