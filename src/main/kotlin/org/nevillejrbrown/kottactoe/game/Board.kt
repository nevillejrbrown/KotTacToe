package org.nevillejrbrown.kottactoe.game

//const val BOARD_SIZE: Int = 3

class Board {

    companion object {
        val BOARD_SIZE: Int = 3
    }

    val contents: Array<Array<Mark>> =
            Array(BOARD_SIZE, { _ -> Array(BOARD_SIZE, { _ -> Mark.BLANK }) })


    fun printBoard() {
        println("--------")
        for (row in contents) {
            print("|")
            for (cell in row) {
                print(cell)
                print("|")
            }
            print("\n")
        }
        println("--------")
    }


    fun isMoveValid(move: Move): Boolean {
        return (move.row >= 0) && (move.row < BOARD_SIZE) &&
                (move.col >= 0) && (move.col < BOARD_SIZE) &&
                contents[move.row][move.col] == (Mark.BLANK)
    }

    fun addMove(move: Move) {
        contents[move.row][move.col] = move.mark
    }

    fun getResult(): GameResult {

        detectIfARowWinsGame()?.let { return it }
        detectIfAColWinsGame()?.let { return it }
        detectIfLeadingDiagonalWins()?.let { return it }
        detectIfTrailingDiagonalWins()?.let { return it }

        // if no winner detected, it is either a stalemate or still in play
        return if (isBoardFull()) GameResult(GameState.STALEMATE, null)
        else GameResult(GameState.IN_PLAY, null)

    }

    fun isBoardFull(): Boolean {
        return contents.find({ it.contains(Mark.BLANK) }) == null
    }

    private fun detectIfARowWinsGame(): GameResult? {
        // look through all the rows, looking for a winner
        // return null otherwise
        val winningRow: Array<Mark>? = contents.find({ IsRowAWinner(it) })

        return if (winningRow != null) {
            GameResult(GameState.WON, winningRow[0])
        } else null

    }

    private fun IsRowAWinner(row: Array<Mark>): Boolean {
        return (row.all({ it == (Mark.CROSS) })) ||
                (row.all({ it == (Mark.NOUGHT) }))
    }

    private fun detectIfAColWinsGame(): GameResult? {
        // go compare whether the i'th row of each row is the same
        for (i in 0..BOARD_SIZE - 1) {
            // TODO this is hardcoded to 3 cells in a column
            if ((contents[0][i] != Mark.BLANK) &&
                    (contents[0][i] == contents[1][i]) &&
                    (contents[1][i] == contents[2][i])) {
                return GameResult(GameState.WON, contents[0][i])
            }
        }
        return null
    }

    /**
     *  Detect this:
     * 		0
     * 		  0
     * 			0
     */
    private fun detectIfLeadingDiagonalWins(): GameResult? {
        // create array out of diagonal marks
        val arrayForDiagonal: Array<Mark> = Array<Mark>(BOARD_SIZE, { i -> contents[i][i] })
        return detectIfArrayContainsWinner(arrayForDiagonal)
    }


    /**
     *  Detect this:
     * 		 	0
     * 		  0
     * 		0
     */
    private fun detectIfTrailingDiagonalWins(): GameResult? {
        // create array out of diagonal marks
        val arrayForDiagonal: Array<Mark> = Array<Mark>(BOARD_SIZE, { i -> contents[i][BOARD_SIZE - i - 1] })
        return detectIfArrayContainsWinner(arrayForDiagonal)
    }

    private fun detectIfArrayContainsWinner(array: Array<Mark>): GameResult? {
        if (array.all({ it.equals(Mark.NOUGHT) })) {
            return GameResult(GameState.WON, Mark.NOUGHT)
        }
        if (array.all({ it.equals(Mark.CROSS) })) {
            return GameResult(GameState.WON, Mark.CROSS)
        }

        return null
    }


}