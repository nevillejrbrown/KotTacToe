package org.nevillejrbrown.kottactoe.strategy

import org.nevillejrbrown.kottactoe.game.Board
import org.nevillejrbrown.kottactoe.game.Mark
import org.nevillejrbrown.kottactoe.game.Move
import org.nevillejrbrown.kottactoe.player.Player
import java.util.*

class RandomMoveStrategy {
    //randomly looks in the grid for a blank space
    fun getMove(board: Board, myPlayer: Player): Move? {
        val randomer: Random = Random()
        var moveFound: Move? = null

        if (!board.isBoardFull()) {
            while (moveFound == null) {
                val row = randomer.nextInt(3)
                val col = randomer.nextInt(3)
                if (board.contents[row][col].equals(Mark.BLANK)) {
                    return Move(row, col, myPlayer.mark)
                }
            }
        }
        return null
    }
}