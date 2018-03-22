package org.nevillejrbrown.kottactoe

import org.junit.Assert
import org.junit.Test
import org.nevillejrbrown.kottactoe.game.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestBoard {
    @Test
    fun `getResult complete first row detected crosses`() {
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.CROSS))
        board.addMove(Move(0, 1, Mark.CROSS))
        board.addMove(Move(0, 2, Mark.CROSS))
        val result: GameResult = board.getResult();

        Assert.assertEquals(GameResult(GameState.WON, Mark.CROSS), result);
    }

    @Test
    fun `getResult complete first row detected noughts`() {
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.NOUGHT))
        board.addMove(Move(0, 1, Mark.NOUGHT))
        board.addMove(Move(0, 2, Mark.NOUGHT))
        val result: GameResult = board.getResult();

        Assert.assertEquals(GameResult(GameState.WON, Mark.NOUGHT), result);
    }

    @Test
    fun `getResult incomplete first row detected`() {
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.CROSS))
        board.addMove(Move(0, 1, Mark.CROSS))
        board.addMove(Move(0, 2, Mark.NOUGHT))
        val result: GameResult = board.getResult();

        Assert.assertEquals(GameResult(GameState.IN_PLAY, null), result);
    }

    @Test
    fun `getResult complete first col detected noughts`() {
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.NOUGHT))
        board.addMove(Move(1, 0, Mark.NOUGHT))
        board.addMove(Move(2, 0, Mark.NOUGHT))
        val result: GameResult = board.getResult();

        Assert.assertEquals(GameResult(GameState.WON, Mark.NOUGHT), result);
    }

    @Test
    fun `getResult empty board returns in play`() {
        val board: Board = Board()
        val result: GameResult = board.getResult();
        Assert.assertEquals(GameResult(GameState.IN_PLAY, null), result);
    }


    @Test
    fun `getResult leading diagonal winner detected noughts`() {
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.NOUGHT))
        board.addMove(Move(1, 1, Mark.NOUGHT))
        board.addMove(Move(2, 2, Mark.NOUGHT))
        val result: GameResult = board.getResult();

        Assert.assertEquals(GameResult(GameState.WON, Mark.NOUGHT), result);
    }


    @Test
    fun `get result leading diagonal winner detected crosses`() {
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.CROSS))
        board.addMove(Move(1, 1, Mark.CROSS))
        board.addMove(Move(2, 2, Mark.CROSS))
        val result: GameResult = board.getResult();

        Assert.assertEquals(GameResult(GameState.WON, Mark.CROSS), result);
    }


    @Test
    fun `get result trailing diagonal winner detected crosses`() {
        val board: Board = Board()
        board.addMove(Move(0, 2, Mark.CROSS))
        board.addMove(Move(1, 1, Mark.CROSS))
        board.addMove(Move(2, 0, Mark.CROSS))
        val result: GameResult = board.getResult();

        Assert.assertEquals(GameResult(GameState.WON, Mark.CROSS), result);
    }

    @Test
    fun `isBoardFull detects full board`() {
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.CROSS))
        board.addMove(Move(0, 1, Mark.CROSS))
        board.addMove(Move(0, 2, Mark.CROSS))
        board.addMove(Move(1, 0, Mark.CROSS))
        board.addMove(Move(1, 1, Mark.CROSS))
        board.addMove(Move(1, 2, Mark.CROSS))
        board.addMove(Move(2, 0, Mark.CROSS))
        board.addMove(Move(2, 1, Mark.CROSS))
        board.addMove(Move(2, 2, Mark.CROSS))
        Assert.assertTrue(board.isBoardFull())
    }

    @Test
    fun `isBoardFull spots single empty spot`() {
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.CROSS))
        board.addMove(Move(0, 1, Mark.CROSS))
        board.addMove(Move(0, 2, Mark.CROSS))
        board.addMove(Move(1, 0, Mark.CROSS))
        board.addMove(Move(1, 1, Mark.CROSS))
        board.addMove(Move(1, 2, Mark.CROSS))
        board.addMove(Move(2, 0, Mark.CROSS))
        board.addMove(Move(2, 1, Mark.CROSS))
        Assert.assertFalse(board.isBoardFull())
    }


    @Test
    fun `isMoveValid detects spot taken`() {
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.CROSS))
        assertFalse(board.isMoveValid(Move(0, 0, Mark.CROSS)))
    }


    @Test
    fun `isMoveValid detects spot free`() {
        val board: Board = Board()
        board.addMove(Move(0, 0, Mark.CROSS))
        assertTrue(board.isMoveValid(Move(0, 1, Mark.CROSS)))
    }

    @Test
    fun `isMoveValid detects out of bounds`() {
        val board: Board = Board()
        assertFalse(board.isMoveValid(Move(3, 3, Mark.CROSS)))
    }
}