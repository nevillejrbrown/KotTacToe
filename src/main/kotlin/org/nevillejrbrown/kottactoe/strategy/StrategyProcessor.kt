package org.nevillejrbrown.kottactoe.strategy

import org.nevillejrbrown.kottactoe.game.Board
import org.nevillejrbrown.kottactoe.game.Move
import org.nevillejrbrown.kottactoe.player.Player

/*
	The strategy processor holds a number of strategies for playing tic tac toe.
	A strategy is a function which takes a board & the player whose go it is and then suggests
	a move for that player to play.
 */
class StrategyProcessor {

    val strategies: MutableList<(board: Board, player: Player) -> Move?> = mutableListOf()

    fun addStrategy(strategy: (board: Board, player: Player) -> Move?) {
        strategies.add(strategy)
    }

    /*
    Get the move
     */
    fun getMove(board: Board, player: Player): Move? {
        // loop through all the strategies and return the first move returned by one
        for (strategy in strategies) {
            strategy(board, player)?.let { return it }
        }
        return null
    }

}