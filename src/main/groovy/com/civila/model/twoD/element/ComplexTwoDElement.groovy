package com.civila.model.twoD.element

import com.civila.model.twoD.Grid
import com.civila.model.twoD.Surface
import com.civila.model.twoD.TwoDPoint

class ComplexTwoDElement<Z, T> implements TwoDElement<Z, T>{
    Z hierarchicalInfo
    List<ResolvedTwoDJoinPoint<Z, T>> children
    Surface area

    @Override
    T getContent() {
        return null
    }

    @Override
    Surface getArea() {
        return area;
    }

    @Override
    Grid<TwoDUnit<Z, T>> getOwnPoints() {
        return Grid.empty()
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof ComplexTwoDElement)) return false

        ComplexTwoDElement that = (ComplexTwoDElement) o

        if (children != that.children) return false

        return true
    }

    int hashCode() {
        return children.hashCode()
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("children", children)
                .toString();
    }
}

class ResolvedTwoDJoinPoint<Z, T>{
    TwoDPoint on;
    TwoDElement<Z, T> element;

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof TwoDJoinPoint)) return false

        TwoDJoinPoint that = (TwoDJoinPoint) o

        if (element != that.element) return false
        if (on != that.on) return false

        return true
    }

    int hashCode() {
        int result
        result = on.hashCode()
        result = 31 * result + element.hashCode()
        return result
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("on", on)
                .add("element", element)
                .toString();
    }
}


class TwoDJoinPoint<Z, T>{
    Closure<TwoDPoint> on;
    TwoDElement<Z, T> element;

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof TwoDJoinPoint)) return false

        TwoDJoinPoint that = (TwoDJoinPoint) o

        if (element != that.element) return false
        if (on != that.on) return false

        return true
    }

    int hashCode() {
        int result
        result = on.hashCode()
        result = 31 * result + element.hashCode()
        return result
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("on", on)
                .add("element", element)
                .toString();
    }
}

