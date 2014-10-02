package com.civila.model.twoD


class TwoDPoint {
    int x
    int y

    static TwoDPoint origin() {
        return new TwoDPoint(x:0, y:0)
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("x", x)
                .add("y", y)
                .toString();
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof TwoDPoint)) return false

        TwoDPoint twoDPoint = (TwoDPoint) o

        if (x != twoDPoint.x) return false
        if (y != twoDPoint.y) return false

        return true
    }

    int hashCode() {
        int result
        result = x
        result = 31 * result + y
        return result
    }

    TwoDPoint plus(TwoDPoint twoDPoint) {
        new TwoDPoint(
            x:this.x + twoDPoint.x,
            y:this.y + twoDPoint.y
        )
    }

    TwoDPoint minus(TwoDPoint twoDPoint) {
        new TwoDPoint(
            x:this.x - twoDPoint.x,
            y:this.y - twoDPoint.y
        )
    }

    boolean isToTheLeft(TwoDPoint twoDPoint) {
        return this.x < twoDPoint.x
    }

    boolean isAtTheTop(TwoDPoint twoDPoint) {
        return this.y > twoDPoint.y
    }

    boolean isToTheRight(TwoDPoint twoDPoint) {
        return this.x > twoDPoint.x
    }

    boolean isAtTheBottom(TwoDPoint twoDPoint) {
        return this.y < twoDPoint.y
    }

    TwoDPoint minusX(int value) {
        new TwoDPoint('x': x - value, 'y': y)
    }

    TwoDPoint plusY(int value) {
        new TwoDPoint('x': x, 'y': y + value)
    }
}
