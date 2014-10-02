package com.civila.data.cities
import com.civila.model.city.InfluenceArea
import com.civila.model.twoD.Block
import com.civila.model.twoD.Placers
import com.civila.model.twoD.Render
import com.civila.model.twoD.Surface
import com.civila.model.twoD.TwoDRenderer
import com.civila.model.twoD.element.Rectangle
import com.civila.model.twoD.element.TwoDElement
import com.civila.model.twoD.element.TwoDElementFactory

import static com.civila.model.city.Faction.FARMERS
import static com.civila.model.city.Faction.KNIGHTS
import static com.civila.model.city.InfluenceArea.faction
import static com.civila.model.city.InfluenceArea.group

class Titani {
    TwoDElementFactory<InfluenceArea, Block> _2dFactory = new TwoDElementFactory<>()
    TwoDRenderer<InfluenceArea, Block> _2dRenderer = new TwoDRenderer<>()

    Render<InfluenceArea, Block> build (){
        TwoDElement<InfluenceArea, Block> titani = _2dFactory.newCompositionWithHierarchicalInfo(){[
            hierarchicalInfoFn : {group("Walled area")},
            compositionBaseFn : { farmers() }
        ]}.
        add([
            onPoint: {Surface parentSurface, Surface thisSurface ->
                Placers.place(thisSurface).bottomLeftCorner().on(parentSurface).topLeftCorner().calculate()
            },
            element: {
                knights()
            }
        ]).compose()

        _2dRenderer.render {titani}
    }

    private Rectangle<InfluenceArea, Block> knights() {
        _2dFactory.rectangle {
            [
                    hierarchicalInfoFn: { faction(KNIGHTS) },
                    gridFn            : {
                        [
                                [_2dFactory.unit { new Block("House") }, _2dFactory.unit { new Block("Commerce") }],
                                [_2dFactory.unit { new Block("House") }, _2dFactory.unit { new Block("HQ") }],
                        ]
                    }
            ]
        }
    }

    private Rectangle<InfluenceArea, Block> farmers() {
        _2dFactory.rowWithHierarchicalInfo {
            [
                    hierarchicalInfoFn: { faction(FARMERS) },
                    rowFn             : {
                        [
                                _2dFactory.unit { new Block("House") },
                                _2dFactory.unit { new Block("HQ") },
                                _2dFactory.unit { new Block("Commerce") },
                                _2dFactory.unit { new Block("House") },
                                _2dFactory.unit { new Block("House") },
                                _2dFactory.unit { new Block("House") },
                        ]
                    }
            ]
        }
    }
}
