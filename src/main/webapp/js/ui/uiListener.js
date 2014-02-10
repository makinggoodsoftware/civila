function UiListener (GridManager){
    this.gridManager = GridManager;
    //noinspection JSUnusedGlobalSymbols
    this.selectedLocation = null;
}

//noinspection JSUnusedGlobalSymbols
UiListener.prototype.navigateNorth = function (fromLocation){
    this.navigateTo (fromLocation, Directions.NORTH);
};

//noinspection JSUnusedGlobalSymbols
UiListener.prototype.navigateSouth = function (fromLocation){
    this.navigateTo (fromLocation, Directions.SOUTH);
};

//noinspection JSUnusedGlobalSymbols
UiListener.prototype.navigateEast = function (fromLocation){
    this.navigateTo (fromLocation, Directions.EAST);
};

//noinspection JSUnusedGlobalSymbols
UiListener.prototype.navigateWest = function (fromLocation){
    this.navigateTo (fromLocation, Directions.WEST);
};

UiListener.prototype.navigateTo = function (fromLocation, direction) {
    var grid = this.gridManager.grid;
    var currentCoordinates = grid.findCoordinates(fromLocation);

    var navigationRequest = new NavigationRequest(
        currentCoordinates,
        currentCoordinates.plus(direction),
        this.selectedLocation.persona
    );

    this.gridManager.applyNavigation(navigationRequest);
};

