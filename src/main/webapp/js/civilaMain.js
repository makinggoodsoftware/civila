angular.module('civila', [], null).

controller('Civila', Civila).
factory ('TerritoryDao', function () {
    return new TerritoryDao ({
        coordinates : new Coordinates (2, 2),
        territory: new Territory(TerritoryTypes.FARMS)
    });
}).
factory ('KnowledgeDao', function () {
    return new KnowledgeDao ({
        'occupied':{
            coordinates : new Coordinates (2, 2),
            personas : [
                new Persona("John Doe")
            ]
        }
    });
}).
service ('GridManager', GridManager).
service ('UiListener', UiListener);
