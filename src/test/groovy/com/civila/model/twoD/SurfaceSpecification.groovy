package com.civila.model.twoD
import spock.lang.Specification
import spock.lang.Unroll

class SurfaceSpecification extends Specification {
    @Unroll ("#area1 + #area2 @ #at should be #expectedArea")
    def "should add two areas" (){
        when:
        Surface result = area1.plus(area2, at)

        then:
        result == expectedArea

        where:
        area1                            | area2                            | at                            | expectedArea
        new Surface(height: 3, width: 3) | new Surface(height: 1, width: 1) | new TwoDPoint(x: 1, y: 1)     | new Surface (height: 3, width: 3)
        new Surface(height: 3, width: 3) | new Surface(height: 1, width: 1) | new TwoDPoint(x: 3, y: 3)     | new Surface (height: 4, width: 4)
        new Surface(height: 3, width: 3) | new Surface(height: 1, width: 1) | new TwoDPoint(x: -1, y: 3)    | new Surface (height: 4, width: 4)
        new Surface(height: 3, width: 3) | new Surface(height: 1, width: 1) | new TwoDPoint(x: -1, y: -1)   | new Surface (height: 4, width: 4)

        new Surface(height: 3, width: 3) | new Surface(height: 2, width: 2) | new TwoDPoint(x: 1, y: 1)     | new Surface (height: 3, width: 3)

        new Surface(height: 3, width: 3) | new Surface(height: 2, width: 2) | new TwoDPoint(x: 2, y: 2)     | new Surface (height: 4, width: 4)
        new Surface(height: 3, width: 3) | new Surface(height: 2, width: 2) | new TwoDPoint(x: 3, y: 3)     | new Surface (height: 5, width: 5)
        new Surface(height: 3, width: 3) | new Surface(height: 2, width: 2) | new TwoDPoint(x: 5, y: 5)     | new Surface (height: 7, width: 7)

        new Surface(height: 3, width: 3) | new Surface(height: 2, width: 2) | new TwoDPoint(x: 1, y: 2)     | new Surface (height: 4, width: 3)
        new Surface(height: 3, width: 3) | new Surface(height: 2, width: 2) | new TwoDPoint(x: 1, y: 3)     | new Surface (height: 5, width: 3)
        new Surface(height: 3, width: 3) | new Surface(height: 2, width: 2) | new TwoDPoint(x: 1, y: 5)     | new Surface (height: 7, width: 3)
        new Surface(height: 3, width: 3) | new Surface(height: 2, width: 2) | new TwoDPoint(x: 5, y: 5)     | new Surface (height: 7, width: 7)
        new Surface(height: 3, width: 3) | new Surface(height: 2, width: 2) | new TwoDPoint(x: -2, y: -2)   | new Surface (height: 5, width: 5)
        new Surface(height: 3, width: 3) | new Surface(height: 2, width: 2) | new TwoDPoint(x: -1, y: -1)   | new Surface (height: 4, width: 4)
        new Surface(height: 3, width: 3) | new Surface(height: 2, width: 2) | new TwoDPoint(x: 2, y: -1)   | new Surface (height: 4, width: 4)

        new Surface(height: 1, width: 1) | new Surface(height: 3, width: 3) | new TwoDPoint(x: -1, y: -1)   | new Surface (height: 3, width: 3)
    }
}
