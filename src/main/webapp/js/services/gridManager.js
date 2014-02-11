function GridManager(TerritoryDao, $http) {
    this.territoryDao = TerritoryDao;
    this.grid = null;
    this.$http = $http
}

GridManager.prototype.rebuildGrid = function (){
    var _this = this;
    this.$http.get("/rest/current/grid").
        success(new function (data) {
            _this.grid = new Grid(data);
    });
//    this.grid = new Grid (6, 8);
//    var knowledge = this.knowledgeDao.gatherKnowledge();
//    var _this = this;
//    knowledge.forEach (
//        function (lastTerritoryPicture, coordinates){
//            var cell = _this.grid.getCell(coordinates);
//            cell.territory = lastTerritoryPicture;
//            cell.personas = [];
//        },
//        function (personas, coordinates){
//            var cell = _this.grid.getCell(coordinates);
//            cell.territory = _this.territoryDao.retrieveTerritoryInfo (coordinates);
//            cell.persona = personas[0];
//        }
//    );
};

GridManager.prototype.applyNavigation = function (navigationRequest){
    console.log("about to navigate from: " +
        JSON.stringify(navigationRequest.from) +
        " to: " + JSON.stringify(navigationRequest.to) + " with " +
        JSON.stringify(navigationRequest.persona));
    var toTerritory = this.territoryDao.retrieveTerritoryInfo(navigationRequest.to);
    var toCell = this.grid.getCell(navigationRequest.to);
    var fromCell = this.grid.getCell(navigationRequest.from);
    toCell.territory = toTerritory;
    toCell.persona = navigationRequest.persona;
    fromCell.persona = null;
};