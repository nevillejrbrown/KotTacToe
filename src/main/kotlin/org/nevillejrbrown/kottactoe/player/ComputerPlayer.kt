package org.nevillejrbrown.kottactoe.player

import org.nevillejrbrown.kottactoe.game.Board
import org.nevillejrbrown.kottactoe.game.Mark
import org.nevillejrbrown.kottactoe.game.Move
import org.nevillejrbrown.kottactoe.strategy.RandomMoveStrategy
import org.nevillejrbrown.kottactoe.strategy.StrategyProcessor
import org.nevillejrbrown.kottactoe.strategy.TryAndWinStrategy

class ComputerPlayer : Player {

    constructor (mark: Mark) : super(mark) {
        strategyProcessor.addStrategy(TryAndWinStrategy()::getMove)
        strategyProcessor.addStrategy(RandomMoveStrategy()::getMove)
    }

    val strategyProcessor: StrategyProcessor = StrategyProcessor()

    override fun getMove(board: Board): Move? {
        return strategyProcessor.getMove(board, this)
    }

}