var TerritoryTypes = new TerritoryType().enums;

function TerritoryType (){
    this.enums = {
        UNKNOWN : "UNKNOWN",
        FARMS : "FARMS"
    }
}

function Location (){
    this.territory = new Territory (TerritoryTypes.UNKNOWN);
    this.population = new Population (0);
}

function Territory (territoryType){
    this.type = territoryType;
}

function Population (size){
    this.size = size;
}