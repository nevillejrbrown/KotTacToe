package org.nevillejrbrown.kottactoe.game

/**
2,0
--------
| | | |
| | | |
|O| | |
--------


 **/

class Move(val row: Int, val col: Int, val mark: Mark) {

    override fun toString(): String {
        return "$row:$col,${mark.toString()}"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Move) {
            return ((this.row == other.row) &&
                    (this.col == other.col) &&
                    (this.mark == other.mark)
                    )
        } else return false
    }
}