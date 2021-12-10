package aoc.day4

import readInput

fun main() {
    val game = BingoGame(readInput("main/kotlin/resources/Day04.txt"))
    game.play()
    println("What will your final score be if you choose that board? " + game.winningBoards.first().finalScore())
    println("Figure out which board will win last. Once it wins, what would its final score be? " + game.winningBoards.last().finalScore())
}