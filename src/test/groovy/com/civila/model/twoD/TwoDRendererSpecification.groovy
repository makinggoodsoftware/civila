package com.civila.model.twoD

import com.civila.model.twoD.element.Rectangle
import com.civila.model.twoD.element.TwoDElement
import com.civila.model.twoD.element.TwoDElementFactory
import com.civila.model.twoD.element.TwoDUnit
import spock.lang.Specification


class TwoDRendererSpecification extends Specification {
    TwoDRenderer<String, String> _2dRenderer
    TwoDElementFactory<String, String> _2dFactory


    def setup(){
        _2dRenderer = new TwoDRenderer<>()
        _2dFactory = new TwoDElementFactory<>()
    }

    def "should render a single unit" (){
        given:
        Rectangle<String, String> rectangleUnit = _2dFactory.unit { "block" }

        when:
        def grid = _2dRenderer.render {rectangleUnit}

        then:
        grid == adaptor{
            [[[rectangleUnit, "block"]]]
        }
    }

    def "should render a rectangle" (){
        given:
        def rectangle = _2dFactory.rectangle { [["1","2"],["3", "4"]] }

        when:
        def grid = _2dRenderer.render {rectangle}

        then:
        grid == adaptor{[
                    [[rectangle, "1"], [rectangle, "2"]],
                    [[rectangle, "3"], [rectangle, "4"]],
                ]}
    }

    def "should create canvas with two elements" (){
        given:
        def _0_0 = new TwoDPoint(x: 0, y: 0)
        def _0_1 = new TwoDPoint(x: 0, y: 1)
        Rectangle<String, String> column = _2dFactory.column { ["columnTop", "columnBottom"] }
        PartialRender<String, String> twoDColumnOn0x0y = new PartialRender(
            anchorPoint: _0_0,
            renderResult : _2dRenderer.render {
                column
            }
        )
        Rectangle<String, String> unit = _2dFactory.unit { "singleBlock" }
        PartialRender<String, String> singleBlockOn0x1y = new PartialRender(
                anchorPoint: _0_1,
                renderResult: _2dRenderer.render {
                    unit
                }
        )

        when:
        Canvas<String, String> canvas = Canvas.from([twoDColumnOn0x0y, singleBlockOn0x1y])

        then:
        canvas.elements.size() == 2
        canvas.elements[twoDColumnOn0x0y] == new OverlappingPoints(on: _0_0, area: new Surface (height: 2, width: 1))
        canvas.elements[singleBlockOn0x1y] == new OverlappingPoints(on: _0_1, area: new Surface (height: 1, width: 1))
        canvas.area == new Surface(width: 1, height: 2)
        canvas.elements[twoDColumnOn0x0y].intersectsOn(new TwoDPoint(x:0, y:0))
        canvas.elements[twoDColumnOn0x0y].intersectsOn(new TwoDPoint(x:0, y:1))
        ! canvas.elements[twoDColumnOn0x0y].intersectsOn(new TwoDPoint(x:1, y:0))
        ! canvas.elements[singleBlockOn0x1y].intersectsOn(new TwoDPoint(x:0, y:0))
        canvas.elements[singleBlockOn0x1y].intersectsOn(new TwoDPoint(x:0, y:1))
        canvas.getLayers(new TwoDPoint(x:0, y:0)) == [
                new Layer(values:[column, new TwoDUnit<String, String>(content:"columnBottom")])
        ]
        canvas.getLayers(new TwoDPoint(x:0, y:1)) == [
                new Layer(values:[column, new TwoDUnit<String, String>(content:"columnTop")]),
                new Layer(values:[unit, new TwoDUnit<String, String>(content:"singleBlock")])
        ]
    }

    def "should render a two elements composition" (){
        given:
        def unit = _2dFactory.unit { "block" }
        def column = _2dFactory.column { ["columnTop", "columnBottom"] }
        def composition = _2dFactory.newComposition{
            column
        }.add(
            onPoint: {parentArea, thisArea -> new TwoDPoint(x:0, y:1)},
            element: {unit}
        ).compose()

        when:
        def grid = _2dRenderer.render {composition}

        then:
        grid == adaptor{[
                [[composition, column, unit, "block"]],
                [[composition, column, "columnBottom"]]
        ]}
    }

    def "city factory test" (){
//        when:
//        _2dFactory.newComposition {
//        }on(
//
//        )
    }


    Render<String, String> adaptor(Closure<List<List<List<Object>>>> arrayListClosure) {
        new Render(renderValue : Grid.from(arrayListClosure ().collect{List<List<Object>> rowDef ->
            rowDef.collect {List<Object> columnDef ->
                new Layer (values :
                    columnDef.collect {Object zLayer ->
                        zLayer instanceof String ? new TwoDUnit<String, String>(content:zLayer) : (TwoDElement<String, String>)zLayer
                    }
                )
            }
        }))
    }

}
