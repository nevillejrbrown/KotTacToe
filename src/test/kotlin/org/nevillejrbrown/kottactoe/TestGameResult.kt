package org.nevillejrbrown.kottactoe

import org.junit.Assert
import org.junit.Test
import org.nevillejrbrown.kottactoe.game.GameResult
import org.nevillejrbrown.kottactoe.game.GameState
import org.nevillejrbrown.kottactoe.game.Mark

class TestGameResult {
    @Test
    fun `equals spots two in_plays equal`() {
        val result1 = GameResult(GameState.IN_PLAY, null)
        val result2 = GameResult(GameState.IN_PLAY, null)

        Assert.assertTrue(result1.equals(result2))

    }

    @Test
    fun `equals in_play does not equal stalemate`() {
        val result1 = GameResult(GameState.IN_PLAY, null)
        val result2 = GameResult(GameState.STALEMATE, null)

        Assert.assertFalse(result1.equals(result2))

    }

    @Test
    fun `equals false if players different`() {
        val result1 = GameResult(GameState.WON, Mark.CROSS)
        val result2 = GameResult(GameState.WON, Mark.NOUGHT)

        Assert.assertFalse(result1.equals(result2))
    }

    @Test
    fun `equals true if players same`() {
        val result1 = GameResult(GameState.WON, Mark.CROSS)
        val result2 = GameResult(GameState.WON, Mark.CROSS)

        Assert.assertTrue(result1.equals(result2))
    }

    @Test
    fun `equals false if a player i null`() {
        val result1 = GameResult(GameState.WON, Mark.CROSS)
        val result2 = GameResult(GameState.WON, null)

        Assert.assertFalse(result1.equals(result2))
    }

}