package aoc.day4

import org.junit.Assert
import org.junit.Test
import readInput
import java.util.stream.Collectors
import java.util.stream.IntStream


class Day04Test {

    @Test
    fun `Final score for winner board`() {
        val game = BingoGame(readInput("test/kotlin/resources/Day04.txt"))
        game.play()
        Assert.assertEquals(4512, game.winningBoards.first().finalScore())
    }
}