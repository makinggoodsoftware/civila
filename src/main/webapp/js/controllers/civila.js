function Civila($scope, UiListener, GridManager) {
    GridManager.rebuildGrid();
    $scope.grid = GridManager.grid;
    $scope.uiListener = UiListener;
}