angular.module('civila', [], null)

.controller('Civila', Civila)
.factory ('LocationDao', function () {
    return new LocationDao ({
        '3':{
            '3': new Location(TerritoryTypes.FARMS, new Persona("John Doe"))
        }
    });
}).
service ('GridFactory', GridFactory).
service ('UiListener', UiListener);