function Civila ($scope, TerritoryDao){
    var grid = new Grid(3, 3);
    TerritoryDao.populate (grid);
    $scope.grid = grid;
}