package aoc.day6

import aoc.day5.HydrothermalVenture
import org.junit.Assert
import org.junit.Test
import readInput

class Day06Test {

    @Test
    fun `Count overlapping lines`() {
        val lanternfish = Lanternfish(readInput("test/kotlin/resources/Day06.txt"))
        Assert.assertEquals(5934, lanternfish.getLaternfishCount(80))
    }

}