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