function Civila ($scope, GridFactory, UiListener){
    $scope.uiListener = UiListener;
    $scope.grid = GridFactory.createNewGrid();
}