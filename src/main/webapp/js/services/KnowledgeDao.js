function KnowledgeDao (config){
    this.hardcodedKnowledge = new Knowledge(config);
}



function Knowledge (knowledgeData){
    this.data = knowledgeData;
}

Knowledge.prototype.forEach = function (memoryFn, occupiedTerritoryFn){
    occupiedTerritoryFn (this.data.occupied.personas, this.data.occupied.coordinates);
};