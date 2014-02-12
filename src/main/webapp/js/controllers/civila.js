function Civila($scope, UiListener, GridManager) {
    GridManager.rebuildGrid();
    $scope.gridManager = GridManager;
    $scope.uiListener = UiListener;
}