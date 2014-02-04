angular.module('civila', [], null)

.controller('Civila', Civila)
.factory ('TerritoryDao', function () {
    var config = {};
    config['2'] = {};
    config['2']['2'] = new Territory ("farms");

    return new TerritoryDao (config);
});