package org.nevillejrbrown.kottactoe

import org.junit.Assert
import org.junit.Test
import org.nevillejrbrown.kottactoe.game.Mark
import org.nevillejrbrown.kottactoe.game.Move

class TestMove {
    @Test
    fun `equals spots two the same`() {
        val move1 = Move(1, 1, Mark.CROSS)
        val move2 = Move(1, 1, Mark.CROSS)
        Assert.assertTrue(move1.equals(move2))
    }

    @Test
    fun `equals spots that marks are different`() {
        val move1 = Move(0, 2, Mark.CROSS)
        val move2 = Move(0, 2, Mark.NOUGHT)
        Assert.assertFalse(move1.equals(move2))
    }

    @Test
    fun `equals spots col different`() {
        val move1 = Move(1, 1, Mark.CROSS)
        val move2 = Move(1, 2, Mark.CROSS)
        Assert.assertFalse(move1.equals(move2))
    }

}