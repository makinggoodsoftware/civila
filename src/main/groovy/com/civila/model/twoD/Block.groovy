package com.civila.model.twoD


class Block {
    final String id

    Block(String id) {
        this.id = id
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Block)) return false

        Block block = (Block) o

        if (id != block.id) return false

        return true
    }

    int hashCode() {
        return (id != null ? id.hashCode() : 0)
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Block{");
        sb.append("id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
