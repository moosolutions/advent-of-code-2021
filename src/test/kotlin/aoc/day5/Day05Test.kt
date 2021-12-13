package aoc.day5

import org.junit.Assert
import org.junit.Test
import readInput

class Day05Test {

    @Test
    fun `Count overlapping lines`() {
        val hydroVents = HydrothermalVenture(readInput("test/kotlin/resources/Day05.txt"))
        Assert.assertEquals(5, hydroVents.getOverlappingLinesCount())
    }

    @Test
    fun `Count overlapping lines with diagonal lines`() {
        val hydroVents = HydrothermalVenture(readInput("test/kotlin/resources/Day05.txt"))
        Assert.assertEquals(12, hydroVents.getOverlappingLinesCountWithDiagonalLines())
    }
}