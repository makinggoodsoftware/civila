angular.module('civila', [], null)

.controller('Civila', Civila)
.factory ('TerritoryDao', function () {
    var config = {};
    config['1'] = {};
    config['1']['2'] = new Territory ("farms");

    return new TerritoryDao (config);
});