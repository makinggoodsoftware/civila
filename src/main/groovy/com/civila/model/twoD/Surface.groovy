package com.civila.model.twoD

class Surface {
    int width, height

    Surface plus (Surface toAdd, TwoDPoint at){
        DelimitedBox toAddBox = toAdd.asBox(at)
        DelimitedBox thisBox = this.asBox()

        DelimitedBox leftMostBox, rightMostBox, topMostBox, bottomMostBox
        leftMostBox = thisBox.leftMost(toAddBox)
        topMostBox = thisBox.topMost(toAddBox)
        rightMostBox = thisBox.rightMost(toAddBox)
        bottomMostBox = thisBox.bottomMost(toAddBox)

        new Surface (
            width: rightMostBox.getBottomRightCorner().x - leftMostBox.getBottomLeftCorner().x,
            height: topMostBox.getTopLeftCorner().y - bottomMostBox.getBottomLeftCorner().y
        )
    }

    public DelimitedBox asBox() {
        asBox(new TwoDPoint(x:0, y:0))
    }

    public DelimitedBox asBox(TwoDPoint at) {
        DelimitedBox.from(this, at)
    }

    Surface incrementHeightBy(int increment) {
        return new Surface ('height': height + increment, width: width)
    }

    boolean contains(TwoDPoint twoDPoint) {
        int widthWithBase0 = this.width - 1
        int heightWithBase0 = this.height - 1

        def xContained = (twoDPoint.x >= 0) && (twoDPoint.x <= widthWithBase0)
        def yContained = (twoDPoint.y >= 0) && (twoDPoint.y <= heightWithBase0)

        return xContained && yContained
    }

    TwoDPoint reverseY(TwoDPoint twoDPoint) {
        int yReversed = (this.height - 1) - twoDPoint.y
        if (yReversed < 0) throw new IllegalArgumentException("Error trying to reverse the y coordinate for ${twoDPoint} in ${this}. The y component of the point to be reversed has to be => than the height of the area -1")
        new TwoDPoint(y:yReversed, x:twoDPoint.x)
    }

    boolean equals (o) {
        if (this.is(o)) return true
        if (!(o instanceof Surface)) return false

        Surface surface = (Surface) o

        if (height != surface.height) return false
        if (width != surface.width) return false

        return true
    }

    int hashCode() {
        int result
        result = width
        result = 31 * result + height
        return result
    }


    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("width", width)
                .add("height", height)
                .toString();
    }

}

class DelimitedBox{
    TwoDPoint topLeftCorner, topRightCorner, bottomLeftCorner, bottomRightCorner

    static DelimitedBox from (Surface surface, TwoDPoint at){
        new DelimitedBox(
            bottomLeftCorner: new TwoDPoint(
                x: at.x,
                y: at.y
            ),
            topLeftCorner: new TwoDPoint(
                x: at.x,
                y: at.y + surface.height
            ),
            bottomRightCorner: new TwoDPoint(
                x: at.x + surface.width,
                y: at.y
            ),
            topRightCorner: new TwoDPoint(
                x: at.x + surface.width,
                y: at.y + surface.height
            ),
        )
    }

    DelimitedBox bottomMost (DelimitedBox delimitedBox){
        if (delimitedBox.bottomLeftCorner.isAtTheBottom(this.bottomLeftCorner)){
            return delimitedBox
        }
        this
    }

    DelimitedBox rightMost (DelimitedBox delimitedBox){
        if (delimitedBox.bottomRightCorner.isToTheRight(this.bottomRightCorner)){
            return delimitedBox
        }
        this
    }

    DelimitedBox leftMost (DelimitedBox delimitedBox){
        if (delimitedBox.bottomLeftCorner.isToTheLeft(this.bottomLeftCorner)){
            return delimitedBox
        }
        this
    }

    DelimitedBox topMost (DelimitedBox delimitedBox){
        if (delimitedBox.topLeftCorner.isAtTheTop(this.topLeftCorner)){
            return delimitedBox
        }
        this
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof DelimitedBox)) return false

        DelimitedBox that = (DelimitedBox) o

        if (bottomLeftCorner != that.bottomLeftCorner) return false
        if (bottomRightCorner != that.bottomRightCorner) return false
        if (topLeftCorner != that.topLeftCorner) return false
        if (topRightCorner != that.topRightCorner) return false

        return true
    }

    int hashCode() {
        int result
        result = topLeftCorner.hashCode()
        result = 31 * result + topRightCorner.hashCode()
        result = 31 * result + bottomLeftCorner.hashCode()
        result = 31 * result + bottomRightCorner.hashCode()
        return result
    }


    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("topLeftCorner", topLeftCorner)
                .add("topRightCorner", topRightCorner)
                .add("bottomLeftCorner", bottomLeftCorner)
                .add("bottomRightCorner", bottomRightCorner)
                .toString();
    }
}
