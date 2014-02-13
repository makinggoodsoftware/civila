function Coordinates (x, y){
    this.x = x;
    this.y = y;
}

Coordinates.prototype.plus = function (direction){
    switch (direction){
        case Directions.NORTH: return new Coordinates (this.x, this.y + 1);
        case Directions.SOUTH: return new Coordinates (this.x, this.y - 1);
        case Directions.EAST: return new Coordinates (this.x + 1, this.y);
        case Directions.WEST: return new Coordinates (this.x - 1, this.y);
    }
    throw new Error("Invalid direction -> " + direction);
};
