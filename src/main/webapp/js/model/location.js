var TerritoryTypes = new TerritoryType().enums;

function TerritoryType (){
    this.enums = {
        UNKNOWN : "UNKNOWN",
        FARMS : "FARMS"
    }
}

function Cell(territoryType, persona) {
    this.territory = new Territory (territoryType);
    this.persona = persona;
}

function Territory (territoryType){
    this.type = territoryType;
}

function Persona(name){
    this.name = name;
}