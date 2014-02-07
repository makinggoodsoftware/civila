angular.module('civila', [], null).

controller('Civila', Civila).
factory ('LocationDao', function () {
    return new LocationDao ({
        '2':{
            '2': new Location(TerritoryTypes.FARMS, new Persona("John Doe"))
        }
    });
}).
service ('GridFactory', GridFactory).
service ('UiListener', UiListener).
service ('Navigator', Navigator).
service ('AppState', function (GridFactory) {
    return new AppState(
        GridFactory.createNewGrid()
    );
});