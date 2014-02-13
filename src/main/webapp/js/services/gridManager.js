function GridManager($http) {
    //noinspection JSUnusedGlobalSymbols
    this.grid = null;
    this.$http = $http
}

GridManager.prototype.rebuildGrid = function (){
    var _this = this;
    this.$http.get("/rest/current/grid").
        success(function (data) {
            _this.grid = data;
    });
};

GridManager.prototype.applyNavigation = function (navigationRequest){
    console.log("about to navigate from: " +
        JSON.stringify(navigationRequest.from) +
        " to: " + JSON.stringify(navigationRequest.to) + " with " +
        JSON.stringify(navigationRequest.persona));
    var _this = this;
    this.$http.post("/rest/actions/navigate/", navigationRequest).
        success(function () {
            _this.rebuildGrid();
        });
};