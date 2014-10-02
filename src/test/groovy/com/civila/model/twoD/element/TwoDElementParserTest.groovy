package com.civila.model.twoD.element

import com.civila.model.twoD.Grid
import spock.lang.Specification
import spock.lang.Unroll


class TwoDElementParserTest extends Specification {
    TwoDElementParser testObj

    void setup() {
        testObj = new TwoDElementParser()
    }

    @Unroll("unit exp: #expressionType")
    def "should parse unit content"() {
        when:
        TwoDElement simpleParse = testObj.parse expression

        then:
        simpleParse.hierarchicalInfo == expectedInfo
        simpleParse.ownPoints == Grid.from(
            [[new TwoDUnit(hierarchicalInfo: null, content: [["hi!"]])]]
        )

        where:
        expressionType                                                  | expression            | expectedInfo
        "static data no hierarchical info"                              | [["hi!"]]                 | null
        "closure data no hierarchical info"                             | {[["hi!"]]}               | null
        "static data with static hierarchical info as static bundle"    | ["info", [["hi!"]]]       | "info"
        "static data with static hierarchical info as closure bundle"   | {["info", [["hi!"]]]}     | "info"
        "static data with closure hierarchical info as static bundle"   | ["info", {[["hi!"]]}]     | "info"
        "static data with closure hierarchical info as closure bundle"  | {["info", {[["hi!"]]}]}   | "info"
        "closure data with static hierarchical info as static bundle"   | [{"info"}, [["hi!"]]]     | "info"
        "closure data with static hierarchical info as closure bundle"  | {[{"info"}, [["hi!"]]]}   | "info"
        "closure data with closure hierarchical info as static bundle"  | [{"info"}, {[["hi!"]]}]   | "info"
        "closure data with closure hierarchical info as closure bundle" | {[{"info"}, {[["hi!"]]}]} | "info"
    }

    @Unroll("row exp: #expressionType")
    def "should parse row content"() {
        when:
        TwoDElement simpleParse = testObj.parseRow expression

        then:
        simpleParse.hierarchicalInfo == expectedInfo
        simpleParse.ownPoints == Grid.from(
                [[new TwoDUnit(hierarchicalInfo: null, content: [["hi!"]]), new TwoDUnit(hierarchicalInfo: null, content: "ho!")]]
        )

        where:
        expressionType                                                  | expression                     | expectedInfo
//        "static data no hierarchical info"                              | [[["hi!"]], "ho!"]                 | null
//        "closure data no hierarchical info"                             | {[[["hi!"]], "ho!"]}               | null
//        "static data with static hierarchical info as static bundle"    | ["info", [[["hi!"]], "ho!"]]       | "info"
//        "static data with static hierarchical info as closure bundle"   | {["info", [[["hi!"]], "ho!"]]}     | "info"
        "static data with closure hierarchical info as static bundle"   | ["info", {[[["hi!"]], "ho!"]}]     | "info"
//        "static data with closure hierarchical info as closure bundle"  | {["info", {[[["hi!"]], "ho!"]}]}   | "info"
//        "closure data with static hierarchical info as static bundle"   | [{"info"}, [[["hi!"]], "ho!"]]     | "info"
//        "closure data with static hierarchical info as closure bundle"  | {[{"info"}, [[["hi!"]], "ho!"]]}   | "info"
//        "closure data with closure hierarchical info as static bundle"  | [{"info"}, {[[["hi!"]], "ho!"]}]   | "info"
//        "closure data with closure hierarchical info as closure bundle" | {[{"info"}, {[[["hi!"]], "ho!"]}]} | "info"
    }

}
