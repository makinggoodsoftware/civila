function CommandsManager ($http, GridManager){
    this.possibleOrders = [{}];
    this.$http = $http;
    this.gridManager = GridManager;
}

CommandsManager.prototype.addCommand = function (command) {
    this.possibleOrders[0].definition = command;
};

CommandsManager.prototype.submitTurn = function (){
    var navigationRequests = [];
    for (var i=0; i<this.possibleOrders.length; i++){
        navigationRequests[i] = this.possibleOrders[i].definition;
    }
    var turn = {
        "navigationRequests": navigationRequests
    };
    var _this = this;
    this.$http.post("/rest/actions/submitTurn", turn).
        success(function () {
            _this.gridManager.rebuildGrid();
            _this.resetCommands ();
        });
};

CommandsManager.prototype.resetCommands = function(){
    this.possibleOrders = [{}];
};