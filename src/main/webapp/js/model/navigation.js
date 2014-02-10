function NavigationRequest(from, to, persona) {
    this.from = from;
    this.to = to;
    this.persona = persona;
}

var Directions = new Direction().enums;

function Direction (){
    this.enums = {
        NORTH : "NORTH",
        SOUTH : "SOUTH",
        EAST : "EAST",
        WEST : "WEST"
    }
}
