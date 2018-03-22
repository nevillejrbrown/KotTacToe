package org.nevillejrbrown.kottactoe.player

import org.nevillejrbrown.kottactoe.game.Board
import org.nevillejrbrown.kottactoe.game.Move

interface IPlayer {

    fun getMove(board: Board): Move?

}