function TerritoryDao(config) {
    this.config = config;
}

TerritoryDao.prototype.retrieveTerritoryInfo = function (coordinates) {
    for (var i=0; i< this.config.length; i++){
        var configCoordinate = this.config[i].coordinates;
        if (configCoordinate.x == coordinates.x && configCoordinate.y == coordinates.y) {
            return this.config[i].territory;
        }
    }
    return null;
};
