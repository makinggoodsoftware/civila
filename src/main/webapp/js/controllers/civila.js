function Civila ($scope, LocationDao){
    var grid = new Grid(3, 3);
    LocationDao.populate (grid);
    $scope.grid = grid;
}