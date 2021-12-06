package aoc.day4

import org.junit.Assert
import org.junit.Test
import readInput

class Day04Test {

    @Test
    fun `Final score for winner board`() {
        val giantSquid = GiantSquid(readInput("test/kotlin/resources/Day04.txt"))
        Assert.assertEquals(4512, giantSquid.getFinalScore())
    }
}