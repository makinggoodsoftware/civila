function TurnManager ($http, GridManager){
    this.turn = null;
    this.$http = $http;
    this.gridManager = GridManager;
}

TurnManager.prototype.addCommand = function (command) {
    this.turn.possibleOrders[0].definition = command;
    this.turn.possibleOrders[0].definition.type = "navigationRequest";
};

TurnManager.prototype.submitTurn = function (){
    var _this = this;
    this.$http.post("/rest/actions/submitTurn", this.turn).
        success(function () {
            _this.gridManager.rebuildGrid();
            _this.resetTurn ();
        });
};

TurnManager.prototype.resetTurn = function(){
    var _this = this;
    var promise = this.$http.get("/rest/current/turn");
    promise.
        success(function (data) {
            _this.turn = data;
        });
    return promise;
};