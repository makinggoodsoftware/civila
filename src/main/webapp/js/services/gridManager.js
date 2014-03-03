function GridManager($http) {
    //noinspection JSUnusedGlobalSymbols
    this.grid = null;
    this.$http = $http;
    this.selectedCell = null;
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
};

GridManager.prototype.select = function (cell) {
    for (var y = 0; y < this.grid.rows.length; y++){
        var row = this.grid.rows[y];
        for (var x = 0; x < row.columns.length; x++){
            var col = row.columns[x]
            delete col.selected
        }
    }
    this.selectedCell = cell;
    cell.selected = true;
};

GridManager.prototype.onKeyPress = function (cell, $event) {
    if ($event.keyCode === 37){

    } else if ($event.keyCode === 38){

    } else if ($event.keyCode === 39){

    } else if ($event.keyCode === 40){

    }
}

GridManager.prototype.cellClassFor = function (cell){
    if (cell.selected) return "selectedCell";
    return "";
};