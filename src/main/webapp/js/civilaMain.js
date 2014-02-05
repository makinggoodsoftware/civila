angular.module('civila', [], null)

.controller('Civila', Civila)
.factory ('LocationDao', function () {
    return new LocationDao ({
        '2':{
            '2':{
                territory: new Territory (TerritoryTypes.FARMS),
                population : new Population (1)
            }
        }
    });
});