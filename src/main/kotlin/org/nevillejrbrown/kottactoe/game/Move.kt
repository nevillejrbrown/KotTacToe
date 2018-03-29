package org.nevillejrbrown.kottactoe.game

/**
2,0
--------
| | | |
| | | |
|O| | |
--------
 **/

data class Move(val row: Int, val col: Int, val mark: Mark)