package com.civila.model.twoD
import com.civila.model.twoD.element.ResolvedTwoDJoinPoint
import com.civila.model.twoD.element.TwoDElement

class TwoDRenderer<Z, T> {
    Render<Z, T> render(Closure<TwoDElement<Z, T>> twoDElementClosure) {
        TwoDElement<Z, T> thisUnrenderedElement = twoDElementClosure()
        if (thisUnrenderedElement.children.size() > 0){
            List<PartialRender<Z, T>> childrenRenders = thisUnrenderedElement.children.collect { ResolvedTwoDJoinPoint<Z, T> joinPoint ->
                new PartialRender (anchorPoint: joinPoint.on, renderResult : render { joinPoint.element })
            }
            return combineChildren(thisUnrenderedElement, childrenRenders)
        }else{
            return renderSingleElement(thisUnrenderedElement)
        }

    }

    Render<Z, T> combineChildren(TwoDElement<Z, T> parentUnrenderedElement, List<PartialRender> childrenRenders) {
        Canvas<Z, T> canvas = Canvas.from(childrenRenders)
        new Render(renderValue:  Grid.from((1..canvas.area.height).collect { int rowIndex ->
            (1..canvas.area.width).collect { int colIndex ->
                TwoDPoint point = new TwoDPoint(x: colIndex - 1, y: rowIndex - 1)
                TwoDPoint reversedPoint = canvas.area.reverseY(point)
                List<Layer<Z, T>> rawChildrenLayers = canvas.getLayers(reversedPoint)
                List<TwoDElement<Z, T>> combinedLayers = [parentUnrenderedElement]

                if (rawChildrenLayers.size() > 1){
                    rawChildrenLayers.take(rawChildrenLayers.size() - 1).each { Layer<Z, T> layerBeforeLast ->
                        List<TwoDElement<Z, T>> values = layerBeforeLast.values
                        combinedLayers.addAll (values.take(values.size() - 1))
                    }
                }
                combinedLayers.addAll(rawChildrenLayers.last().values)
                new Layer(values: combinedLayers)
            }
        }))
    }

    private Render<Z, T> renderSingleElement(TwoDElement<Z, T> toRender) {
        new Render(renderValue:  toRender.ownPoints.transform { value ->
            new Layer(values:[toRender, value])
        })
    }
}


class OverlappingPoints<T>{
    TwoDPoint on
    Surface area

    boolean intersectsOn(TwoDPoint twoDPoint) {
        return area.contains(getRelativeCoordinate(twoDPoint));
    }

    TwoDPoint getRelativeCoordinate(TwoDPoint twoDPoint) {
        return twoDPoint.minus(on)
    }


    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("on", on)
                .add("area", area)
                .toString();
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof OverlappingPoints)) return false

        OverlappingPoints that = (OverlappingPoints) o

        if (area != that.area) return false
        if (on != that.on) return false

        return true
    }

    int hashCode() {
        int result
        result = on.hashCode()
        result = 31 * result + area.hashCode()
        return result
    }
}

class Layer<Z, T>{
    List<TwoDElement<Z, T>> values


    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("values", values)
                .toString();
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Layer)) return false

        Layer layer = (Layer) o

        if (values != layer.values) return false

        return true
    }

    int hashCode() {
        return values.hashCode()
    }
}

class Canvas<Z, T>{
    Surface area
    Map<PartialRender, OverlappingPoints<T>> elements

    static Canvas<Z, T> from(List<PartialRender> partialRenders) {
        Map<PartialRender, OverlappingPoints> canvasElements = partialRenders.collectEntries { PartialRender partialRender ->
            [partialRender, new OverlappingPoints<T>(on: partialRender.anchorPoint, area: partialRender.getRenderResult().area)]
        }
        return new Canvas<Z, T>(
                area: new Surface(height: 2, width: 1),
                elements: canvasElements
        )
    }

    List<Layer<Z, T>> getLayers(TwoDPoint currentCoordinate) {
        List<Layer<Z, T>> layers = []
        elements.each { PartialRender<Z, T> partialRender, OverlappingPoints<T> overlappingPoints ->
            if (overlappingPoints.intersectsOn(currentCoordinate)) {
                TwoDPoint relativeCoordinateCoordinate = overlappingPoints.getRelativeCoordinate(currentCoordinate)
                layers << partialRender.renderResult.getContent(relativeCoordinateCoordinate)
            }
        }
        layers
    }
}

class PartialRender<Z, T>{
    TwoDPoint anchorPoint;
    Render<Z, T> renderResult;

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof PartialRender)) return false

        PartialRender that = (PartialRender) o

        if (anchorPoint != that.anchorPoint) return false
        if (renderResult != that.renderResult) return false

        return true
    }

    int hashCode() {
        int result
        result = anchorPoint.hashCode()
        result = 31 * result + renderResult.hashCode()
        return result
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("anchorPoint", anchorPoint)
                .add("renderResult", renderResult)
                .toString();
    }
}
