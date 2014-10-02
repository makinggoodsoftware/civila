package com.civila.data.cities
import com.civila.model.city.InfluenceArea
import com.civila.model.twoD.Block
import com.civila.model.twoD.Render
import com.civila.model.twoD.TwoDPoint
import groovy.json.JsonBuilder
import spock.lang.Specification

class TitaniTest extends Specification {

    def "should build titani" (){
        when:
        Render<InfluenceArea, Block> titaniRender = new Titani().build()

        def content = new Titani().build().getContent(TwoDPoint.origin()).values[0].children[0].element.ownPoints.gridData[0][0].ownPoints.getAsRawData()[0][0].getContent().getOwnPoints().getAsRawData()[0][0]
        println content
        println new JsonBuilder(["hi","ho"]).toPrettyString()

        then:
        titaniRender.renderValue.elements == 2
    }

    def "test json builder" (){
        when:
        def builder = new JsonBuilder()
        def root = builder.root{
            element1{"asd"}
        }

        println builder.toPrettyString()

        then:
        true
    }
}
