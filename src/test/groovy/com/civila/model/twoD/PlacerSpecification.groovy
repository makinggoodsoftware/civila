package com.civila.model.twoD
import spock.lang.Specification
import spock.lang.Unroll

import static com.civila.model.twoD.Placers.place

class PlacerSpecification extends Specification {

    @Unroll ("placing #surfaceToPlace-#onCorner at #baseSurface-#atCorner")
    def "should place correctly when is collocated in default position 0_0 aka bottomLeftCorner" (){
        when:
        TwoDPoint placementPoint = place(surfaceToPlace)."$onCorner"().on(baseSurface)."$atCorner"().calculate()

        then:
        placementPoint == expectedFinishedPlacement

        where:
        surfaceToPlace                      | onCorner              | baseSurface                        | atCorner             | expectedFinishedPlacement
        new Surface(width: 1, height: 1)    | "bottomLeftCorner"    |new Surface(width: 1, height: 1)    | "bottomLeftCorner"   | new TwoDPoint(x:0, y:0)
        new Surface(width: 1, height: 1)    | "bottomLeftCorner"    |new Surface(width: 1, height: 1)    | "bottomRightCorner"  | new TwoDPoint(x:1, y:0)
        new Surface(width: 1, height: 1)    | "bottomLeftCorner"    |new Surface(width: 1, height: 1)    | "topLeftCorner"      | new TwoDPoint(x:0, y:1)
        new Surface(width: 1, height: 1)    | "bottomLeftCorner"    |new Surface(width: 1, height: 1)    | "topRightCorner"     | new TwoDPoint(x:1, y:1)

        new Surface(width: 1, height: 1)    | "bottomRightCorner"   |new Surface(width: 1, height: 1)    | "bottomLeftCorner"   | new TwoDPoint(x:-1, y:0)
        new Surface(width: 1, height: 1)    | "bottomRightCorner"   |new Surface(width: 1, height: 1)    | "bottomRightCorner"  | new TwoDPoint(x:0, y:0)
        new Surface(width: 1, height: 1)    | "bottomRightCorner"   |new Surface(width: 1, height: 1)    | "topLeftCorner"      | new TwoDPoint(x:-1, y:1)
        new Surface(width: 1, height: 1)    | "bottomRightCorner"   |new Surface(width: 1, height: 1)    | "topRightCorner"     | new TwoDPoint(x:0, y:1)

        new Surface(width: 1, height: 1)    | "topLeftCorner"       |new Surface(width: 1, height: 1)    | "bottomLeftCorner"   | new TwoDPoint(x:0, y:-1)
        new Surface(width: 1, height: 1)    | "topLeftCorner"       |new Surface(width: 1, height: 1)    | "bottomRightCorner"  | new TwoDPoint(x:1, y:-1)
        new Surface(width: 1, height: 1)    | "topLeftCorner"       |new Surface(width: 1, height: 1)    | "topLeftCorner"      | new TwoDPoint(x:0, y:0)
        new Surface(width: 1, height: 1)    | "topLeftCorner"       |new Surface(width: 1, height: 1)    | "topRightCorner"     | new TwoDPoint(x:1, y:0)

        new Surface(width: 1, height: 1)    | "topRightCorner"      |new Surface(width: 1, height: 1)    | "bottomLeftCorner"   | new TwoDPoint(x:-1, y:-1)
        new Surface(width: 1, height: 1)    | "topRightCorner"      |new Surface(width: 1, height: 1)    | "bottomRightCorner"  | new TwoDPoint(x:0, y:-1)
        new Surface(width: 1, height: 1)    | "topRightCorner"      |new Surface(width: 1, height: 1)    | "topLeftCorner"      | new TwoDPoint(x:-1, y:0)
        new Surface(width: 1, height: 1)    | "topRightCorner"      |new Surface(width: 1, height: 1)    | "topRightCorner"     | new TwoDPoint(x:0, y:0)



        new Surface(width: 2, height: 2)    | "bottomLeftCorner"    |new Surface(width: 3, height: 3)    | "bottomLeftCorner"   | new TwoDPoint(x:0, y:0)
        new Surface(width: 2, height: 2)    | "bottomLeftCorner"    |new Surface(width: 3, height: 3)    | "bottomRightCorner"  | new TwoDPoint(x:3, y:0)
        new Surface(width: 2, height: 2)    | "bottomLeftCorner"    |new Surface(width: 3, height: 3)    | "topLeftCorner"      | new TwoDPoint(x:0, y:3)
        new Surface(width: 2, height: 2)    | "bottomLeftCorner"    |new Surface(width: 3, height: 3)    | "topRightCorner"     | new TwoDPoint(x:3, y:3)

        new Surface(width: 2, height: 2)    | "bottomRightCorner"   |new Surface(width: 3, height: 3)    | "bottomLeftCorner"   | new TwoDPoint(x:-2, y:0)
        new Surface(width: 2, height: 2)    | "bottomRightCorner"   |new Surface(width: 3, height: 3)    | "bottomRightCorner"  | new TwoDPoint(x:1, y:0)
        new Surface(width: 2, height: 2)    | "bottomRightCorner"   |new Surface(width: 3, height: 3)    | "topLeftCorner"      | new TwoDPoint(x:-2, y:3)
        new Surface(width: 2, height: 2)    | "bottomRightCorner"   |new Surface(width: 3, height: 3)    | "topRightCorner"     | new TwoDPoint(x:1, y:3)

        new Surface(width: 2, height: 2)    | "topLeftCorner"       |new Surface(width: 3, height: 3)    | "bottomLeftCorner"   | new TwoDPoint(x:0, y:-2)
        new Surface(width: 2, height: 2)    | "topLeftCorner"       |new Surface(width: 3, height: 3)    | "bottomRightCorner"  | new TwoDPoint(x:3, y:-2)
        new Surface(width: 2, height: 2)    | "topLeftCorner"       |new Surface(width: 3, height: 3)    | "topLeftCorner"      | new TwoDPoint(x:0, y:1)
        new Surface(width: 2, height: 2)    | "topLeftCorner"       |new Surface(width: 3, height: 3)    | "topRightCorner"     | new TwoDPoint(x:3, y:1)

        new Surface(width: 2, height: 2)    | "topRightCorner"      |new Surface(width: 3, height: 3)    | "bottomLeftCorner"   | new TwoDPoint(x:-2, y:-2)
        new Surface(width: 2, height: 2)    | "topRightCorner"      |new Surface(width: 3, height: 3)    | "bottomRightCorner"  | new TwoDPoint(x:1, y:-2)
        new Surface(width: 2, height: 2)    | "topRightCorner"      |new Surface(width: 3, height: 3)    | "topLeftCorner"      | new TwoDPoint(x:-2, y:1)
        new Surface(width: 2, height: 2)    | "topRightCorner"      |new Surface(width: 3, height: 3)    | "topRightCorner"     | new TwoDPoint(x:1, y:1)

    }
}
