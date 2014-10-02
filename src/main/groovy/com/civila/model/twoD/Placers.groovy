package com.civila.model.twoD

class Placers {
    static Placer place(Surface toPlace) {
        Placer placer = new Placer()
        placer.toPlaceDescription.surface = toPlace
        placer
    }
}

class PlacingDescription {
    Surface surface
    TwoDPoint corner
    int deltaX, deltaY

    def topLeftCorner() {
        deltaX = 0
        deltaY = this.surface.height
    }

    def topRightCorner() {
        deltaX = this.surface.width
        deltaY = this.surface.height
    }

    def bottomRightCorner() {
        deltaX = this.surface.width
        deltaY = 0
    }

    def bottomLeftCorner() {
        deltaX = 0
        deltaY = 0
    }
}

class Placer {
    PlacingDescription basePlacingDescription = new PlacingDescription()
    PlacingDescription toPlaceDescription = new PlacingDescription()
    PlacingDescription context = toPlaceDescription

    Placer on(Surface on) {
        this.context = basePlacingDescription
        this.context.surface = on
        this
    }

    Placer topLeftCorner() {
        this.context.topLeftCorner()
        this
    }


    Placer topRightCorner() {
        this.context.topRightCorner()
        this
    }

    Placer bottomRightCorner() {
        this.context.bottomRightCorner()
        this
    }

    Placer bottomLeftCorner() {
        this.context.bottomLeftCorner()
        this
    }

    TwoDPoint calculate() {
        new TwoDPoint(
                x: this.basePlacingDescription.deltaX - this.toPlaceDescription.deltaX,
                y: this.basePlacingDescription.deltaY - this.toPlaceDescription.deltaY
        )
    }
}

public enum PlacingConditions {
    STARTS, FINISHES
}
