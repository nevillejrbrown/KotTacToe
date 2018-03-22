package org.nevillejrbrown.kottactoe.strategy

import org.nevillejrbrown.kottactoe.game.BOARD_SIZE
import org.nevillejrbrown.kottactoe.game.Board
import org.nevillejrbrown.kottactoe.game.Mark
import org.nevillejrbrown.kottactoe.game.Move
import org.nevillejrbrown.kottactoe.player.Player

class TryAndWinStrategy {

    fun getMove(board: Board, player: Player): Move? {
        val processor: StrategyProcessor = StrategyProcessor()
        processor.addStrategy(::seekColumnToWin)
        processor.addStrategy(::seekRowToWin)
        processor.addStrategy(::seekLeadingRowWin)
        processor.addStrategy(::seekTrailingRowWin)
        return processor.getMove(board, player)
    }


    private fun seekColumnToWin(board: Board, player: Player): Move? {
        var moveFound: Move? = null
        for (colNum in 0..(BOARD_SIZE - 1)) {
            // create an array out of the values of board[0,1,2][colNum]
            val arrayOfCol: Array<Mark> = Array(BOARD_SIZE, { i -> board.contents[i][colNum] })
            val indexOfWinnerInCol = seekWinnerInArray(arrayOfCol, player)
            if (indexOfWinnerInCol >= 0) {
                moveFound = Move(indexOfWinnerInCol, colNum, player.mark)
            }
        }
        return moveFound
    }

    private fun seekRowToWin(board: Board, player: Player): Move? {
        var moveFound: Move? = null
        for ((rowNum, row) in board.contents.withIndex()) {
            val indexOfWinnerInRow = seekWinnerInArray(row, player)
            if (indexOfWinnerInRow >= 0) {
                moveFound = Move(rowNum, indexOfWinnerInRow, player.mark)
            }
        }
        return moveFound
    }

    /*
    Find:
            X - -
            - X -
            - - X
     */
    private fun seekLeadingRowWin(board: Board, player: Player): Move? {
        // create an array out of the leading diagonal
        val leadingDiagonalAsArray = Array(BOARD_SIZE, { i -> board.contents[i][i] })
        val winnerPosition = seekWinnerInArray(leadingDiagonalAsArray, player)
        return if (winnerPosition > 0)
            Move(winnerPosition, winnerPosition, player.mark)
        else null
    }

    /*
     Find:
             - - O
             - 0 -
             0 - -
      */
    private fun seekTrailingRowWin(board: Board, player: Player): Move? {
        // create an array out of the trailing diagonal
        val trailingDiagonalAsArray = Array(BOARD_SIZE, { i -> board.contents[i][BOARD_SIZE - 1 - i] })
        val winnerPosition = seekWinnerInArray(trailingDiagonalAsArray, player)
        return if (winnerPosition > 0)
            Move(winnerPosition, BOARD_SIZE - winnerPosition - 1, player.mark)
        else null
    }


    private fun seekWinnerInArray(array: Array<Mark>, player: Player): Int {
        // row must have single blank
        if (array.count({ it.equals(Mark.BLANK) }) == 1) {
            // row must have board size - 1 of its own mark
            if (array.count({ it.equals(player.mark) }) == BOARD_SIZE - 1) {
                // find index of the blank
                return array.indexOf(Mark.BLANK)
            }
        }
        return -1
    }


}