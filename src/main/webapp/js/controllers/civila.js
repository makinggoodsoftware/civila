function Civila($scope, $q, UiListener, GridManager, TurnManager) {
    $q.all(
        GridManager.rebuildGrid(),
        TurnManager.resetTurn()
    ).then(
        function (){
            UiListener.selectedBlock = GridManager.getBlock(0, 0);
        }
    );

    $scope.gridManager = GridManager;
    $scope.uiListener = UiListener;
    $scope.turnManager = TurnManager;
}