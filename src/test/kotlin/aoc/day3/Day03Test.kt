package aoc.day3

import org.junit.Assert
import org.junit.Test
import readInput

class Day03Test {

    @Test
    fun `Power consumption`() {
        val power = BinaryDiagnostic(readInput("test/kotlin/resources/Day03.txt"))
        Assert.assertEquals(198, power.getPowerConsumption())
    }

    @Test
    fun `Live support rating`() {
        val power = BinaryDiagnostic(readInput("test/kotlin/resources/Day03.txt"))
        Assert.assertEquals(230, power.getLiveSupportRating())
    }
}