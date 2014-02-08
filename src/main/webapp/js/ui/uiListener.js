function UiListener (GridManager){
    this.gridManager = GridManager;
    //noinspection JSUnusedGlobalSymbols
    this.selectedLocation = null;
}

//noinspection JSUnusedGlobalSymbols
UiListener.prototype.navigateNorth = function (location){
    var grid = this.gridManager.grid;
    var currentCoordinates = grid.findCoordinates(location);

    var navigationRequest = new NavigationRequest(
        currentCoordinates,
        currentCoordinates.north(),
        this.selectedLocation.persona
    );

    this.gridManager.applyNavigation (navigationRequest);
};

