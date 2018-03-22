package org.nevillejrbrown.kottactoe.player

import org.nevillejrbrown.kottactoe.game.Board
import org.nevillejrbrown.kottactoe.game.Mark
import org.nevillejrbrown.kottactoe.game.Move

class HumanPlayer : Player {

    constructor (mark: Mark) : super(mark)

    override fun getMove(board: Board): Move {
        var move: Move? = null
        while (move == null) {
            move = getMoveFromCommandLine()
        }
        return move
    }

    fun getMoveFromCommandLine(): Move? {
        print("Your move, human (row,column):")
        val readIn: String? = readLine();
        val moves: List<String> = readIn?.split(",") ?: listOf("", "")

        return try {
            Move(moves.get(0).toInt(), moves.get(1).toInt(), this.mark)
        } catch (ex: NumberFormatException) {
            null
        }
    }
}