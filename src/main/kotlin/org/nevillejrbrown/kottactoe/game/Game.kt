package org.nevillejrbrown.kottactoe.game

import org.nevillejrbrown.kottactoe.player.ComputerPlayer
import org.nevillejrbrown.kottactoe.player.HumanPlayer
import org.nevillejrbrown.kottactoe.player.IPlayer

class Game {


    fun play() {
        val board: Board = Board();

        val player1: IPlayer = HumanPlayer(Mark.NOUGHT)
        val player2: IPlayer = ComputerPlayer(Mark.CROSS)
        var currentPlayer: IPlayer = player1
        while (board.getResult().equals(GameResult(GameState.IN_PLAY, null))) {

            val move = currentPlayer.getMove(board)
            if (move != null) {
                if (board.isMoveValid(move)) {
                    board.addMove(move)
                    if (currentPlayer.equals(player1)) {
                        currentPlayer = player2
                    } else {
                        currentPlayer = player1
                    }
                    board.printBoard()
                } else {
                    println("Invalid move: $move")
                }
            } else {
                println("null move returned from player")
            }
        }
        println("GAME OVER! RESULT:")
        println(board.getResult())
    }
}