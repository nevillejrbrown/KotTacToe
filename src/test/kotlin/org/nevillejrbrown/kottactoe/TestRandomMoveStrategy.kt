package org.nevillejrbrown.kottactoe

import org.junit.Test
import org.nevillejrbrown.kottactoe.game.Board
import org.nevillejrbrown.kottactoe.game.Mark
import org.nevillejrbrown.kottactoe.game.Move
import org.nevillejrbrown.kottactoe.player.ComputerPlayer
import org.nevillejrbrown.kottactoe.player.Player
import org.nevillejrbrown.kottactoe.strategy.RandomMoveStrategy
import kotlin.test.assertEquals
import kotlin.test.assertNull


class TestRandomMoveStrategy {

    @Test
    fun `test getMove find last spot available`() {
        val board: Board = Board()
        val player: Player = ComputerPlayer(Mark.CROSS)
        board.addMove(Move(0, 0, Mark.CROSS))
        board.addMove(Move(0, 1, Mark.CROSS))
        board.addMove(Move(0, 2, Mark.CROSS))
        board.addMove(Move(1, 0, Mark.CROSS))
        board.addMove(Move(1, 1, Mark.CROSS))
        board.addMove(Move(1, 2, Mark.CROSS))
        board.addMove(Move(2, 0, Mark.CROSS))
        board.addMove(Move(2, 1, Mark.CROSS))

        val strategy = RandomMoveStrategy()
        val expectedMove = Move(2, 2, Mark.CROSS)
        assertEquals(expectedMove, strategy.getMove(board, player))

    }

    @Test
    fun `test getMove returns null for full board`() {
        val board: Board = Board()
        val player: Player = ComputerPlayer(Mark.CROSS)
        board.addMove(Move(0, 0, Mark.CROSS))
        board.addMove(Move(0, 1, Mark.CROSS))
        board.addMove(Move(0, 2, Mark.CROSS))
        board.addMove(Move(1, 0, Mark.CROSS))
        board.addMove(Move(1, 1, Mark.CROSS))
        board.addMove(Move(1, 2, Mark.CROSS))
        board.addMove(Move(2, 0, Mark.CROSS))
        board.addMove(Move(2, 1, Mark.CROSS))
        board.addMove(Move(2, 2, Mark.CROSS))
        val strategy = RandomMoveStrategy()
        assertNull(strategy.getMove(board, player))
    }
}