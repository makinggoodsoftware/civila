package com.civila.model.twoD.element


class TwoDElementParser <Z, T>{
    TwoDElementFactory<Z, T> twoDElementFactory = new TwoDElementFactory<>()

    TwoDElement<Z, T> parse(toParse){
        if (toParse instanceof Closure){
            return parse(toParse())
        }
        if ((toParse instanceof List) && (! toParse[0] instanceof List)){
            return parse([null, toParse])
            List toParseAsList = toParse

            Closure hierarchicalInfoFn
            List rowElements

            def secondElement = toParseAsList[1] instanceof Closure ? toParseAsList[1] () : toParseAsList[1]

            if (secondElement instanceof List){
                hierarchicalInfoFn = toParseAsList[0] instanceof Closure ? toParseAsList[0] : {toParseAsList[0]} as Closure
                rowElements = secondElement
            }else{
                hierarchicalInfoFn = {null}
                rowElements = toParseAsList
            }

            return twoDElementFactory.rectangle({[
                    hierarchicalInfoFn: hierarchicalInfoFn,
                    gridFn: [] ? [].collect{[rowElements]} : {[rowElements]}
            ]})
        }
        throw new IllegalArgumentException("Invalid input to parse row: ${toParse}")
    }
}
