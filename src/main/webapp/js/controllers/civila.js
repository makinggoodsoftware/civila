function Civila($scope, UiListener, GridManager, TurnManager) {
    GridManager.rebuildGrid();
    TurnManager.resetTurn();

    $scope.gridManager = GridManager;
    $scope.uiListener = UiListener;
    $scope.turnManager = TurnManager;
}