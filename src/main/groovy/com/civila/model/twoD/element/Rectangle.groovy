package com.civila.model.twoD.element

import com.civila.model.twoD.Grid
import com.civila.model.twoD.Surface

class Rectangle<Z, T> implements TwoDElement<Z, T>{
    Z hierarchicalInfo
    Grid<TwoDUnit<Z, T>> grid

    @Override
    T getContent() {
        return null
    }

    @Override
    Surface getArea() {
        return grid.getArea()
    }

    @Override
    Grid<TwoDUnit<Z, T>> getOwnPoints() {
        return grid
    }

    @Override
    List<ResolvedTwoDJoinPoint<Z, T>> getChildren() {
        return []
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Rectangle)) return false

        Rectangle rectangle = (Rectangle) o

        if (grid != rectangle.grid) return false

        return true
    }

    int hashCode() {
        return grid.hashCode()
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rectangle{");
        sb.append("grid=").append(grid);
        sb.append('}');
        return sb.toString();
    }
}
