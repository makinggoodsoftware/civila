function UiListener (Navigator, AppState){
    this.navigator = Navigator;
    this.appState = AppState;

    //noinspection JSUnusedGlobalSymbols
    this.selectedLocation = null;
}

//noinspection JSUnusedGlobalSymbols
UiListener.prototype.navigateNorth = function (location){
    var grid = this.appState.grid;
    var currentCoordinates = grid.findCoordinates(location);

    this.navigator.navigate(
        grid,
        currentCoordinates,
        currentCoordinates.north(),
        this.selectedLocation.persona
    )
};

