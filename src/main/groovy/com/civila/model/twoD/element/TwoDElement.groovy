package com.civila.model.twoD.element

import com.civila.model.twoD.Grid
import com.civila.model.twoD.Surface

interface TwoDElement<Z, T> {
    @SuppressWarnings("GroovyUnusedDeclaration")
    Z getHierarchicalInfo()

    T getContent()

    Surface getArea ()

    Grid<TwoDUnit<Z, T>> getOwnPoints()

    List<ResolvedTwoDJoinPoint<Z, T>> getChildren()
}
