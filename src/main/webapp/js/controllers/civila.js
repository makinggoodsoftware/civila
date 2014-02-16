function Civila($scope, UiListener, GridManager, CommandsManager) {
    GridManager.rebuildGrid();
    $scope.gridManager = GridManager;
    $scope.uiListener = UiListener;
    $scope.commandsManager = CommandsManager;
}