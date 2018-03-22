package org.nevillejrbrown.kottactoe.game

class GameResult(val state: GameState, val winner: Mark?) {

    override fun toString(): String {
        return (state.toString() + ":" + winner?.toString())
    }

    override fun equals(other: Any?): Boolean {
        if (other is GameResult) {
            return (this.state == other.state) &&
                    (this.winner == other.winner)
        } else return false

    }
}