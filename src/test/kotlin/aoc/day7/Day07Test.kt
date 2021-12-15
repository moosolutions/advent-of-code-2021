package aoc.day7

import org.junit.Assert
import org.junit.Test
import readInput

class Day07Test {

    @Test
    fun `Get fuel to align them all`() {
        val input = readInput("test/kotlin/resources/Day07.txt")
        val whale = TreacheryOfWhale(input.first().split(',').map { it.toInt() })
        Assert.assertEquals(37, whale.getFuelToSpend(true))
    }

    @Test
    fun `Get cheapest possible outcome`() {
        val input = readInput("test/kotlin/resources/Day07.txt")
        val whale = TreacheryOfWhale(input.first().split(',').map { it.toInt() })
        Assert.assertEquals(168, whale.getFuelToSpend(false))
    }
}