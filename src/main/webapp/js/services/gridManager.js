function GridManager($http) {
    //noinspection JSUnusedGlobalSymbols
    this.grid = null;
    this.$http = $http
}

GridManager.prototype.rebuildGrid = function (){
    var _this = this;
    var promise = this.$http.get("/rest/current/grid");
    promise.
        success(function (data) {
            _this.grid = data;
    });
    return promise;
};

GridManager.prototype.getBlock = function (x, y){
    return this.grid.rows[y+2].columns[x+2];
}