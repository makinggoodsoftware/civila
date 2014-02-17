function UiListener (TurnManager){
    //noinspection JSUnusedGlobalSymbols
    this.selectedBlock = null;
    this.turnManager = TurnManager;
}

//noinspection JSUnusedGlobalSymbols
UiListener.prototype.navigateNorth = function (fromBlock){
    this.navigateTo (fromBlock, Directions.NORTH);
};

//noinspection JSUnusedGlobalSymbols
UiListener.prototype.navigateSouth = function (fromBlock){
    this.navigateTo (fromBlock, Directions.SOUTH);
};

//noinspection JSUnusedGlobalSymbols
UiListener.prototype.navigateEast = function (fromBlock){
    this.navigateTo (fromBlock, Directions.EAST);
};

//noinspection JSUnusedGlobalSymbols
UiListener.prototype.navigateWest = function (fromBlock){
    this.navigateTo (fromBlock, Directions.WEST);
};

UiListener.prototype.navigateTo = function (fromBlock, direction) {
    var currentCoordinates = angular.extend(new Coordinates(null, null), fromBlock.coordinates);

    var navigationRequest = new NavigationRequest(
        currentCoordinates,
        currentCoordinates.plus(direction),
        this.selectedBlock.persona
    );

    this.turnManager.addCommand (navigationRequest);
};

UiListener.prototype.submitTurn = function (){
    this.turnManager.submitTurn();
};

