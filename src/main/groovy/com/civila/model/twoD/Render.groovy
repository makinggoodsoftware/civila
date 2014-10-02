package com.civila.model.twoD


class Render<Z, T> {
    Grid<Layer<Z, T>> renderValue;

    Surface getArea() {
        renderValue.getArea()
    }

    Layer<Z, T> getContent(TwoDPoint twoDPoint) {
        renderValue.getContent(twoDPoint)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Render)) return false

        Render render = (Render) o

        if (renderValue != render.renderValue) return false

        return true
    }

    int hashCode() {
        return renderValue.hashCode()
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("renderValue", renderValue)
                .toString();
    }
}
