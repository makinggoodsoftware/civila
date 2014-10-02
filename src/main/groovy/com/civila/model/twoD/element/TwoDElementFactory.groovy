package com.civila.model.twoD.element
import com.civila.model.twoD.Grid
import com.civila.model.twoD.Surface
import com.civila.model.twoD.TwoDPoint

import static com.civila.model.twoD.TwoDPoint.origin

class TwoDElementFactory<Z, T> {
    Rectangle<Z, T> rectangle(initFn) {

        def (Z hierarchichalInfo, Closure<List<List<Object>>> gridFn) = buildRectangleInfo(initFn)

        new Rectangle (
            hierarchicalInfo: hierarchichalInfo,
            grid : Grid.from (
                gridFn().collect {List<Object> rawRow ->
                    rawRow.collect {Object toEnrich ->
                        generateUnit(toEnrich)
                    }
                }
            )
        )
    }

    private List buildRectangleInfo(initFn) {
        def initValues = initFn()
        if (initValues instanceof Map){
            if ((initValues["hierarchicalInfoFn"]) && (initValues["gridFn"])){
                return [initValues.hierarchicalInfoFn(), initValues.gridFn]
            }
        }else{
            if (initValues instanceof List){
                return [null, initFn]
            }
        }
        throw new IllegalArgumentException("Incorrect value used to initialise a rectangle, it has to be either a Map with hierarchical info and a grid Function, or a grid Function. The passed value is: $initValues")
    }

    Rectangle<Z, T> unit(Closure<Object> unitContentFn) {
        def unitContentValues = unitContentFn ()

        if (unitContentValues instanceof List && unitContentValues.size() == 2){
            List listParams = unitContentValues
            def hierarchicalInfoFn = (listParams[0] instanceof Closure) ? listParams[0] : {listParams[0]}
            return unitWithHierarchicalInfo {[
                    hierarchicalInfoFn: hierarchicalInfoFn,
                    unitFn:  listParams[1]
            ]}
        }
        rectangle {[[unitContentValues]]}
    }

    private Rectangle<Z, T> unitWithHierarchicalInfo(Closure<Object> initFn) {
        def initValues = initFn()
        rectangle {[
            hierarchicalInfoFn: initValues.hierarchicalInfoFn,
            gridFn: {[[initValues.unitFn()]]}
        ]}
    }

    Rectangle<Z, T> row(Closure<List<Object>> rowFn) {
        def rectangleContentValues = rowFn ()
        if (rectangleContentValues instanceof List && rectangleContentValues.size() == 2 && rectangleContentValues[1] instanceof List){
            List listParams = rectangleContentValues
            def hierarchicalInfoFn = (listParams[0] instanceof Closure) ? listParams[0] : {listParams[0]}
            def rowFnVal = (listParams[1] instanceof Closure) ? listParams[1] : {listParams[1]}
            return rowWithHierarchicalInfo {[
                    hierarchicalInfoFn: hierarchicalInfoFn,
                    rowFn:  rowFnVal
            ]}
        }
        rectangle {[rowFn()]}
    }

    private Rectangle<Z, T> rowWithHierarchicalInfo(Closure<Object> initFn) {
        def initValues = initFn()
        rectangle {[
            hierarchicalInfoFn: initValues.hierarchicalInfoFn,
            gridFn : {[initValues.rowFn()]}
        ]}
    }

    Rectangle<Z, T> column(Closure<List<Object>> colFn) {
        def rectangleContentValues = colFn ()
        if (rectangleContentValues instanceof List && rectangleContentValues.size() == 2 && rectangleContentValues[1] instanceof List){
            List listParams = rectangleContentValues
            def hierarchicalInfoFn = (listParams[0] instanceof Closure) ? listParams[0] : {listParams[0]}
            def rowFnVal = (listParams[1] instanceof Closure) ? listParams[1] : {listParams[1]}
            return columnWithHierarchicalInfo {[
                    hierarchicalInfoFn: hierarchicalInfoFn,
                    columnFn:  rowFnVal
            ]}
        }

        List<List<Object>> grid = []
        List<Object> cols = colFn()
        cols.each {col->
            grid << [col]
        }
        rectangle {grid}
    }

    private Rectangle<Z, T> columnWithHierarchicalInfo(initFn) {
        def initValues = initFn()
        rectangle {[
            hierarchicalInfoFn: initValues.hierarchicalInfoFn,
            gridFn : {initValues.columnFn().collect {[it]}}
        ]}
    }

    private TwoDUnit generateUnit(Object content) {
        if (content instanceof T) {
            return new TwoDUnit<Z, T>(content: content)
        } else if (content instanceof TwoDUnit) {
            TwoDUnit maybeEmptyElement = content
            if (!maybeEmptyElement.isEmpty()) throw new RuntimeException("Can't create a rectangle with a populated unit: ${maybeEmptyElement}")
            return maybeEmptyElement
        } else {
            throw new RuntimeException("Passed the wrong type of object to the rectangle constructor. Must be a block o an empty TwoDUnit. Actual content ${content}")
        }
    }

    def Composition<Z, T> newComposition(compositionBaseFn) {
        new Composition<Z, T>(baseElement: compositionBaseFn())
    }

    def Composition<Z, T> newCompositionWithHierarchicalInfo(initFn) {
        def initValues = initFn()
        new Composition<Z, T>(baseElement: initValues.compositionBaseFn(), hierarchicalInfo:  initValues.hierarchicalInfoFn())
    }

}

class Composition<Z, T>{
    TwoDElement<Z, T> baseElement
    List<TwoDJoinPoint<Z, T>> addedElements = []
    Z hierarchicalInfo

    Composition<Z, T> add (toAdd) {
        addedElements << new TwoDJoinPoint<Z, T>(on: toAdd.onPoint, element: toAdd.element())
        this
    }

    TwoDElement<Z, T> compose() {
        Surface accumulatedArea = this.baseElement.area
        List<ResolvedTwoDJoinPoint<Z, T>> resolvedTwoDJoinPointList = []
        resolvedTwoDJoinPointList << new ResolvedTwoDJoinPoint<Z, T>(on: origin(), element: this.baseElement)

        addedElements.each {TwoDJoinPoint<Z, T> compositionElement ->
            TwoDPoint resolvedAnchorPoint = compositionElement.on(this.baseElement.area, compositionElement.element.area)
            resolvedTwoDJoinPointList << new ResolvedTwoDJoinPoint<Z, T>(on: resolvedAnchorPoint, element: compositionElement.element)
            accumulatedArea = accumulatedArea.plus(compositionElement.element.area, resolvedAnchorPoint)
        }
        new ComplexTwoDElement<Z, T>(children:resolvedTwoDJoinPointList, area: accumulatedArea, hierarchicalInfo: this.hierarchicalInfo)
    }
}

