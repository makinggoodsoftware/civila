package com.civila.model.twoD.element

import com.civila.model.twoD.Grid
import com.civila.model.twoD.Surface
import org.codehaus.jackson.annotate.JsonIgnore

class TwoDUnit<Z, T> implements TwoDElement<Z, T>{
    Z hierarchicalInfo
    public static final _1x1_AREA = new Surface (height: 1, width: 1)
    T content
    Grid<TwoDUnit<Z, T>> ownPoints = Grid.singleElement (this)
    List<ResolvedTwoDJoinPoint<Z, T>> children = []
    boolean empty

    @JsonIgnore
    def isEmpty(){

    }

    private static final TwoDUnit EMPTY = new TwoDUnit(empty : true)

    static TwoDUnit empty() {
        EMPTY
    }

    @Override
    Surface getArea() {
        return _1x1_AREA
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof TwoDUnit)) return false

        TwoDUnit twoDUnit = (TwoDUnit) o

        if (content != twoDUnit.content) return false

        return true
    }

    int hashCode() {
        int result
        result = 31 * result + content.hashCode()
        return result
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("content", content)
                .toString();
    }
}
