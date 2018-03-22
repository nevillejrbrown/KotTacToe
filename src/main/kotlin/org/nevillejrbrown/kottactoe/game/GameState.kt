package org.nevillejrbrown.kottactoe.game

enum class GameState(stateLabel: String) {
    IN_PLAY("still playing"),
    STALEMATE("stalemate!"),
    WON("org.nevillejrbrown.kottactoe.game.Game won!")
}