package org.nevillejrbrown.kottactoe.game

enum class Mark(val visibleMark: String) {
    BLANK(" "), CROSS("X"), NOUGHT("O");

    override fun toString(): String {
        return visibleMark
    }
}