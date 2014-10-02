package com.civila.model.twoD

import com.civila.model.twoD.element.Rectangle
import com.civila.model.twoD.element.TwoDElement
import com.civila.model.twoD.element.TwoDElementFactory
import spock.lang.Specification

import static com.civila.model.twoD.Placers.place
import static com.civila.model.twoD.element.TwoDUnit.empty

class TwoDElementFactorySpecification extends Specification {
    TwoDElementFactory _2dFactory

    def setup() {
        _2dFactory = new TwoDElementFactory<String, Block>()
    }

    def "should create single block 2d Model"() {
        given:
        Block singleBlock = new Block("TEST")

        when:
        TwoDElement model = _2dFactory.unit { singleBlock }

        then:
        summary(model) == [[singleBlock]]
        model.children.size() == 0
    }

    def "should create single block 2d Model with hierarchical info"() {
        given:
        Block singleBlock = new Block("TEST")
        String hierarchicalInfo = "Test Hierarchy"

        when:
        TwoDElement model = _2dFactory.unit {[hierarchicalInfo,{ singleBlock }]}

        then:
        summary(model) == [[singleBlock]]
        model.children.size() == 0
        model.hierarchicalInfo == hierarchicalInfo
    }

    def "should create a 2d horizontal model with 2 blocks"() {
        given:
        def singleBlockLeft = new Block("TEST1")
        def singleBlockRight = new Block("TEST2")

        when:
        TwoDElement model = _2dFactory.row { [singleBlockLeft, singleBlockRight] }

        then:
        summary(model) ==
                [
                        [singleBlockLeft, singleBlockRight]
                ]
        model.children.size() == 0
    }

    def "should create a 2d horizontal model with 2 blocks and hierarchical info"() {
        given:
        def singleBlockLeft = new Block("TEST1")
        def singleBlockRight = new Block("TEST2")
        String hierarchicalInfo = "Test Hierarchy"

        when:
        TwoDElement model = _2dFactory.row {[hierarchicalInfo,
            [singleBlockLeft, singleBlockRight]
        ]}

        then:
        summary(model) ==
                [
                        [singleBlockLeft, singleBlockRight]
                ]
        model.children.size() == 0
        model.hierarchicalInfo == hierarchicalInfo
    }

    def "should create a 2d vertical model with 2 blocks"() {
        given:
        def singleBlockUp = new Block("TEST1")
        def singleBlockDown = new Block("TEST2")

        when:
        TwoDElement model = _2dFactory.column { [singleBlockUp, singleBlockDown] }

        then:
        summary(model) ==
                [
                        [singleBlockUp],
                        [singleBlockDown]
                ]
        model.children.size() == 0
    }

    def "should create a 2d vertical model with 2 blocks and hierarchical info"() {
        given:
        def singleBlockUp = new Block("TEST1")
        def singleBlockDown = new Block("TEST2")
        String hierarchicalInfo = "Test Hierarchy"

        when:
        TwoDElement model = _2dFactory.column {[hierarchicalInfo ,
            [singleBlockUp, singleBlockDown]
        ]}

        then:
        summary(model) ==
                [
                        [singleBlockUp],
                        [singleBlockDown]
                ]
        model.children.size() == 0
        model.hierarchicalInfo == hierarchicalInfo
    }


    def "should create a 2d vertical model for a 3x3 rectangle"() {
        given:
        def singleBlock1_1 = new Block("TEST1_1")
        def singleBlock1_2 = new Block("TEST1_2")
        def singleBlock1_3 = new Block("TEST1_3")

        def singleBlock2_1 = new Block("TEST2_1")
        def singleBlock2_2 = new Block("TEST2_2")
        def singleBlock2_3 = new Block("TEST2_3")

        def singleBlock3_1 = new Block("TEST3_1")
        def singleBlock3_2 = new Block("TEST3_2")
        def singleBlock3_3 = new Block("TEST3_3")

        when:
        TwoDElement model = _2dFactory.rectangle {
            [
                    [singleBlock1_1, singleBlock1_2, singleBlock1_3],
                    [singleBlock2_1, singleBlock2_2, singleBlock2_3],
                    [singleBlock3_1, singleBlock3_2, singleBlock3_3],
            ]
        }

        then:
        summary(model) ==
                [
                        [singleBlock1_1, singleBlock1_2, singleBlock1_3],
                        [singleBlock2_1, singleBlock2_2, singleBlock2_3],
                        [singleBlock3_1, singleBlock3_2, singleBlock3_3],
                ]
        model.children.size() == 0
    }

    def "should create a 2d vertical model for a 3x3 rectangle with hierarchical info"() {
        given:
        def singleBlock1_1 = new Block("TEST1_1")
        def singleBlock1_2 = new Block("TEST1_2")
        def singleBlock1_3 = new Block("TEST1_3")

        def singleBlock2_1 = new Block("TEST2_1")
        def singleBlock2_2 = new Block("TEST2_2")
        def singleBlock2_3 = new Block("TEST2_3")

        def singleBlock3_1 = new Block("TEST3_1")
        def singleBlock3_2 = new Block("TEST3_2")
        def singleBlock3_3 = new Block("TEST3_3")
        String hierarchicalInfo = "Test Hierarchy"

        when:
        TwoDElement model = _2dFactory.rectangle {
            [
                    hierarchicalInfoFn: { hierarchicalInfo },
                    gridFn            : {
                        [
                                [singleBlock1_1, singleBlock1_2, singleBlock1_3],
                                [singleBlock2_1, singleBlock2_2, singleBlock2_3],
                                [singleBlock3_1, singleBlock3_2, singleBlock3_3],
                        ]
                    }
            ]
        }

        then:
        summary(model) ==
                [
                        [singleBlock1_1, singleBlock1_2, singleBlock1_3],
                        [singleBlock2_1, singleBlock2_2, singleBlock2_3],
                        [singleBlock3_1, singleBlock3_2, singleBlock3_3],
                ]
        model.children.size() == 0
        model.hierarchicalInfo == hierarchicalInfo
    }


    def "should create irregular shaped rectangle"() {
        given:
        def singleBlock1_1 = new Block("TEST1_1")
        def singleBlock1_2 = new Block("TEST1_2")

        def singleBlock2_1 = new Block("TEST2_1")

        when:
        def model = _2dFactory.rectangle {
            [
                    [singleBlock1_1, singleBlock1_2],
                    [singleBlock2_1, empty()]
            ]
        }

        then:
        summary(model) ==
                [
                        [singleBlock1_1, singleBlock1_2],
                        [singleBlock2_1, empty()],
                ]
        model.children.size() == 0
    }

    def "should create hollow shaped rectangle"() {
        given:
        def singleBlock1_1 = new Block("TEST1_1")
        def singleBlock1_2 = new Block("TEST1_2")
        def singleBlock1_3 = new Block("TEST1_3")

        def singleBlock2_1 = new Block("TEST2_1")
        def singleBlock2_3 = new Block("TEST2_3")

        def singleBlock3_1 = new Block("TEST3_1")
        def singleBlock3_2 = new Block("TEST3_2")
        def singleBlock3_3 = new Block("TEST3_3")

        when:
        def model = _2dFactory.rectangle {
            [
                    [singleBlock1_1, singleBlock1_2, singleBlock1_3],
                    [singleBlock2_1, empty(), singleBlock2_3],
                    [singleBlock3_1, singleBlock3_2, singleBlock3_3],
            ]
        }

        then:
        summary(model) ==
                [
                        [singleBlock1_1, singleBlock1_2, singleBlock1_3],
                        [singleBlock2_1, empty(), singleBlock2_3],
                        [singleBlock3_1, singleBlock3_2, singleBlock3_3],
                ]
        model.children.size() == 0
    }

    def "should throw exception if building irregular rectangle"() {
        given:
        def singleBlock1_1 = new Block("TEST1_1")
        def singleBlock1_2 = new Block("TEST1_2")
        def singleBlock1_3 = new Block("TEST1_3")

        def singleBlock2_1 = new Block("TEST2_1")
        def singleBlock2_2 = new Block("TEST2_2")

        when:
        _2dFactory.rectangle {
            [
                    [singleBlock1_1, singleBlock1_2, singleBlock1_3],
                    [singleBlock2_1, singleBlock2_2]
            ]
        }

        then:
        thrown IllegalArgumentException
    }

    def "should allow inner composition of one element"() {
        given:
        def singleBlock = _2dFactory.unit { "TestInner" }
        def _3x3Grid = _2dFactory.rectangle {
            (1..3).collect { rowIndx ->
                (1..3).collect { columnIndx ->
                    "Test${rowIndx}_${columnIndx}"
                }
            }
        }

        when:
        TwoDElement _3x3GridWithBlockInTheMiddle =
                _2dFactory.newComposition { _3x3Grid }.
                        add(
                                onPoint: { parentArea, thisArea -> new TwoDPoint(x: 1, y: 1) },
                                element: { singleBlock }
                        ).
                        compose()

        then:
        summary(_3x3GridWithBlockInTheMiddle) == [[]]
        _3x3GridWithBlockInTheMiddle.area == new Surface(height: 3, width: 3)
        _3x3GridWithBlockInTheMiddle.children.size() == 2
        _3x3GridWithBlockInTheMiddle.children[0].on == new TwoDPoint(x: 0, y: 0)
        _3x3GridWithBlockInTheMiddle.children[0].element == _3x3Grid
        _3x3GridWithBlockInTheMiddle.children[1].on == new TwoDPoint(x: 1, y: 1)
        _3x3GridWithBlockInTheMiddle.children[1].element == singleBlock
    }

    def "should allow inner composition of one element with hierarchical info"() {
        given:
        def singleBlock = _2dFactory.unit { "TestInner" }
        def _3x3Grid = _2dFactory.rectangle {
            (1..3).collect { rowIndx ->
                (1..3).collect { columnIndx ->
                    "Test${rowIndx}_${columnIndx}"
                }
            }
        }
        String hierarchicalInfo = "Test Hierarchy"

        when:
        TwoDElement _3x3GridWithBlockInTheMiddle =
                _2dFactory.newCompositionWithHierarchicalInfo {
                    [
                            hierarchicalInfoFn: { hierarchicalInfo },
                            compositionBaseFn : { _3x3Grid }
                    ]
                }.add(
                        onPoint: { parentArea, thisArea -> new TwoDPoint(x: 1, y: 1) },
                        element: { singleBlock }
                ).compose()

        then:
        summary(_3x3GridWithBlockInTheMiddle) == [[]]
        _3x3GridWithBlockInTheMiddle.area == new Surface(height: 3, width: 3)
        _3x3GridWithBlockInTheMiddle.children.size() == 2
        _3x3GridWithBlockInTheMiddle.children[0].on == new TwoDPoint(x: 0, y: 0)
        _3x3GridWithBlockInTheMiddle.children[0].element == _3x3Grid
        _3x3GridWithBlockInTheMiddle.children[1].on == new TwoDPoint(x: 1, y: 1)
        _3x3GridWithBlockInTheMiddle.children[1].element == singleBlock
        _3x3GridWithBlockInTheMiddle.hierarchicalInfo == hierarchicalInfo
    }


    def "should allow overlapping composition of one element"() {
        given:
        def twoBlocksColumn = _2dFactory.column { ["Up", "Down"] }
        def _3x3Grid = _2dFactory.rectangle {
            (1..3).collect { rowIndx ->
                (1..3).collect { columnIndx ->
                    "Test${rowIndx}_${columnIndx}"
                }
            }
        }

        when:
        TwoDElement _3x3GridWithBlockInTheMiddle =
                _2dFactory.newComposition { _3x3Grid }.
                        add(
                                onPoint: { parentArea, thisArea -> new TwoDPoint(x: 1, y: 2) },
                                element: { twoBlocksColumn }
                        ).
                        compose()

        then:
        summary(_3x3GridWithBlockInTheMiddle) == [[]]
        _3x3GridWithBlockInTheMiddle.area == new Surface(height: 4, width: 3)
        _3x3GridWithBlockInTheMiddle.children.size() == 2
        _3x3GridWithBlockInTheMiddle.children[0].on == new TwoDPoint(x: 0, y: 0)
        _3x3GridWithBlockInTheMiddle.children[0].element == _3x3Grid
        _3x3GridWithBlockInTheMiddle.children[1].on == new TwoDPoint(x: 1, y: 2)
        _3x3GridWithBlockInTheMiddle.children[1].element == twoBlocksColumn
    }

    def "should allow overlapping composition of many elements"() {
        given:
        def twoBlocksColumn = _2dFactory.column { ["Up", "Down"] }
        def _3x3Grid = _2dFactory.rectangle {
            (1..3).collect { rowIndx ->
                (1..3).collect { columnIndx ->
                    "Test${rowIndx}_${columnIndx}"
                }
            }
        }
        def singleBlock = _2dFactory.unit { "TestInner" }

        when:
        TwoDElement _3x3GridWithBlockInTheMiddle =
                _2dFactory.newComposition { _3x3Grid }.
                        add(
                                onPoint: { parentArea, thisArea -> new TwoDPoint(x: 1, y: 2) },
                                element: { twoBlocksColumn }
                        ).
                        add(
                                onPoint: { parentArea, thisArea -> new TwoDPoint(x: 1, y: 1) },
                                element: { singleBlock }
                        ).
                        compose()

        then:
        summary(_3x3GridWithBlockInTheMiddle) == [[]]
        _3x3GridWithBlockInTheMiddle.area == new Surface(height: 4, width: 3)
        _3x3GridWithBlockInTheMiddle.children.size() == 3
        _3x3GridWithBlockInTheMiddle.children[0].on == new TwoDPoint(x: 0, y: 0)
        _3x3GridWithBlockInTheMiddle.children[0].element == _3x3Grid
        _3x3GridWithBlockInTheMiddle.children[1].on == new TwoDPoint(x: 1, y: 2)
        _3x3GridWithBlockInTheMiddle.children[1].element == twoBlocksColumn
        _3x3GridWithBlockInTheMiddle.children[2].on == new TwoDPoint(x: 1, y: 1)
        _3x3GridWithBlockInTheMiddle.children[2].element == singleBlock
    }

    def "should allow nested composition"() {
        given:
        def twoBlocksColumn = _2dFactory.column { ["Up", "Down"] }
        def _3x3Grid = _2dFactory.rectangle {
            (1..3).collect { rowIndx ->
                (1..3).collect { columnIndx ->
                    "Test${rowIndx}_${columnIndx}"
                }
            }
        }
        def singleBlock = _2dFactory.unit { "TestInner" }
        when:
        TwoDElement _3x3GridWithBlockInTheMiddle =
                _2dFactory.newComposition {
                    _2dFactory.newComposition {
                        _3x3Grid
                    }.add(
                            onPoint: { parentArea, thisArea -> new TwoDPoint(x: 3, y: 3) },
                            element: { singleBlock }
                    ).compose()
                }.add(
                        onPoint: { parentArea, thisArea -> new TwoDPoint(x: 1, y: 2) },
                        element: {
                            _2dFactory.newComposition {
                                _3x3Grid
                            }.add(
                                    onPoint: { parentArea, thisArea -> new TwoDPoint(x: 2, y: 2) },
                                    element: { twoBlocksColumn }
                            ).compose()
                        }
                ).compose()

        then:
        summary(_3x3GridWithBlockInTheMiddle) == [[]]
        _3x3GridWithBlockInTheMiddle.children.size() == 2
        _3x3GridWithBlockInTheMiddle.children[0].on == new TwoDPoint(x: 0, y: 0)
        _3x3GridWithBlockInTheMiddle.children[0].element.children.size() == 2
        _3x3GridWithBlockInTheMiddle.children[0].element.children[0].on == new TwoDPoint(x: 0, y: 0)
        _3x3GridWithBlockInTheMiddle.children[0].element.children[0].element == _3x3Grid
        _3x3GridWithBlockInTheMiddle.children[0].element.children[1].on == new TwoDPoint(x: 3, y: 3)
        _3x3GridWithBlockInTheMiddle.children[0].element.children[1].element == singleBlock
        _3x3GridWithBlockInTheMiddle.children[1].on == new TwoDPoint(x: 1, y: 2)
        _3x3GridWithBlockInTheMiddle.children[1].element.children.size() == 2
        _3x3GridWithBlockInTheMiddle.children[1].element.children[0].on == new TwoDPoint(x: 0, y: 0)
        _3x3GridWithBlockInTheMiddle.children[1].element.children[0].element == _3x3Grid
        _3x3GridWithBlockInTheMiddle.children[1].element.children[1].on == new TwoDPoint(x: 2, y: 2)
        _3x3GridWithBlockInTheMiddle.children[1].element.children[1].element == twoBlocksColumn
    }

    private static List<List<Block>> summary(TwoDElement model) {
        model.ownPoints.transform {
            it.content
        }.asRawData
    }

    @SuppressWarnings("GroovyVariableNotAssigned")
    def "should receive two surfaces on the composition callback for 2 simple elements"() {
        given:
        Surface parentSurfaceCallback
        Surface thisSurfaceCallback

        when:
        _2dFactory.newComposition {
            _2dFactory.row { ["A", "B"] }
        }.add(
                onPoint: { Surface parentSurface, Surface thisSurface ->
                    parentSurfaceCallback = parentSurface
                    thisSurfaceCallback = thisSurface
                    new TwoDPoint(x: 0, y: 0)
                },
                element: { _2dFactory.column { ["C", "D"] } }
        ).compose()

        then:

        //noinspection GroovyVariableNotAssigned
        parentSurfaceCallback == new Surface(height: 1, width: 2)
        //noinspection GroovyVariableNotAssigned
        thisSurfaceCallback == new Surface(height: 2, width: 1)
    }

    def "should receive two surfaces on the composition callback with one complex element"() {
        given:
        Surface parentSurfaceCallback
        Surface thisSurfaceCallback

        when:
        _2dFactory.newComposition {
            _2dFactory.row { ["A", "B"] }
        }.add(
                onPoint: { parentSurface, thisSurface -> TwoDPoint.origin() },
                element: { _2dFactory.column { ["C", "D"] } }
        ).add(
                onPoint: { Surface parentSurface, Surface thisSurface ->
                    parentSurfaceCallback = parentSurface
                    thisSurfaceCallback = thisSurface
                    TwoDPoint.origin()
                },
                element: { _2dFactory.column { ["C", "D"] } }
        ).compose()

        //noinspection GroovyVariableNotAssigned
        then:
        //noinspection GroovyVariableNotAssigned
        parentSurfaceCallback == new Surface(height: 1, width: 2)
        //noinspection GroovyVariableNotAssigned
        thisSurfaceCallback == new Surface(height: 2, width: 1)
    }

    /**
     *  Trying to generate the following shape
     *
     *            EFG
     *            D
     *          ABC
     *
     */
    def "should compose with more than one join point"() {
        given:
        Rectangle rowABC = _2dFactory.row { ["A", "B", "C"] }
        Rectangle unitD = _2dFactory.unit { "D" }
        Rectangle rowEFG = _2dFactory.row { ["E", "F", "G"] }


        when:
        TwoDElement tetrisShape =
                _2dFactory.newComposition {
                    rowABC
                }.add(
                        onPoint: { Surface parentSurface, Surface thisSurface ->
                            place(thisSurface).bottomRightCorner().on(parentSurface).topRightCorner().calculate()
                        },
                        element: { unitD }
                ).add(
                        onPoint: { Surface parentSurface, Surface thisSurface ->
                            new TwoDPoint(x: 2, y: 2)
                        },
                        element: { rowEFG }
                ).compose()

        then:
        tetrisShape.area == new Surface(height: 3, width: 5)
        tetrisShape.children.size() == 3
    }
}
