function GridManager (TerritoryDao, KnowledgeDao) {
    this.territoryDao = TerritoryDao;
    this.knowledgeDao = KnowledgeDao;
    this.grid = null;
}

GridManager.prototype.rebuildGrid = function (){
    this.grid = new Grid (6, 8);
    var knowledge = this.knowledgeDao.gatherKnowledge();
    var _this = this;
    knowledge.forEach (
        function (lastTerritoryPicture, coordinates){
            var cell = _this.grid.getCell(coordinates);
            cell.territory = lastTerritoryPicture;
            cell.personas = [];
        },
        function (personas, coordinates){
            var cell = _this.grid.getCell(coordinates);
            cell.territory = _this.territoryDao.retrieveTerritoryInfo (coordinates);
            cell.persona = personas[0];
        }
    );
};

GridManager.prototype.applyNavigation = function (navigationRequest){
    console.log("about to navigate from: " +
        JSON.stringify(navigationRequest.from) +
        " to: " + JSON.stringify(navigationRequest.to) + " with " +
        JSON.stringify(navigationRequest.persona));
};