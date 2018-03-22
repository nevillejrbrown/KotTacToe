package org.nevillejrbrown.kottactoe

import org.junit.Test
import org.nevillejrbrown.kottactoe.game.Board
import org.nevillejrbrown.kottactoe.game.Mark
import org.nevillejrbrown.kottactoe.game.Move
import org.nevillejrbrown.kottactoe.player.ComputerPlayer
import org.nevillejrbrown.kottactoe.player.Player
import org.nevillejrbrown.kottactoe.strategy.TryAndWinStrategy
import kotlin.test.assertEquals

class TestTryAndWinStrategy {

    @Test
    fun `getMove detects last spot first col`() {
        val player: Player = ComputerPlayer(Mark.CROSS)
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.CROSS))
        board.addMove(Move(1, 0, Mark.CROSS))

        val strategy = TryAndWinStrategy()
        val expectedMove = Move(2, 0, Mark.CROSS)
        assertEquals(expectedMove, strategy.getMove(board, player))

    }


    @Test
    fun `getMove detects last spot third col`() {
        val player: Player = ComputerPlayer(Mark.CROSS)
        val board: Board = Board()
        board.addMove(Move(0, 2, Mark.CROSS))
        board.addMove(Move(1, 2, Mark.CROSS))

        val strategy = TryAndWinStrategy()
        val expectedMove = Move(2, 2, Mark.CROSS)
        assertEquals(expectedMove, strategy.getMove(board, player))

    }

    @Test
    fun `getMove detects last spot first row`() {
        val player: Player = ComputerPlayer(Mark.CROSS)
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.CROSS))
        board.addMove(Move(0, 1, Mark.CROSS))

        val strategy = TryAndWinStrategy()
        val expectedMove = Move(0, 2, Mark.CROSS)
        assertEquals(expectedMove, strategy.getMove(board, player))

    }

    @Test
    fun `getMove detects last spot last row`() {
        val player: Player = ComputerPlayer(Mark.CROSS)
        val board: Board = Board()
        board.addMove(Move(2, 0, Mark.CROSS))
        board.addMove(Move(2, 1, Mark.CROSS))

        val strategy = TryAndWinStrategy()
        val expectedMove = Move(2, 2, Mark.CROSS)
        assertEquals(expectedMove, strategy.getMove(board, player))

    }

    @Test
    fun `getMove detects middle of leading diagonal for crosses`() {
        val player = ComputerPlayer(Mark.CROSS)
        val board = Board()
        board.addMove(Move(0, 0, Mark.CROSS))
        board.addMove(Move(2, 2, Mark.CROSS))

        val strategy = TryAndWinStrategy()
        val expectedMove = Move(1, 1, Mark.CROSS)
        assertEquals(expectedMove, strategy.getMove(board, player))

    }


    @Test
    fun `getMove detects top right of trailing diagonal for noughts`() {
        val player = ComputerPlayer(Mark.NOUGHT)
        val board = Board()
        board.addMove(Move(0, 2, Mark.NOUGHT))
        board.addMove(Move(1, 1, Mark.NOUGHT))

        val strategy = TryAndWinStrategy()
        val expectedMove = Move(2, 0, Mark.NOUGHT)
        assertEquals(expectedMove, strategy.getMove(board, player))

    }


}