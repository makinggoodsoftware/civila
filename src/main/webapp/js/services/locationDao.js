function LocationDao(config) {
    this.config = config;
}

LocationDao.prototype.findLocation = function (row, column) {
    if (this.config[row] && this.config[row][column]) {
        return this.config[row][column];
    }
    return null;
};
