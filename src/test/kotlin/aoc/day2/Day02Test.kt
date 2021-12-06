package aoc.day2

import org.junit.Assert
import org.junit.Test
import readInput

class Day02Test {

    @Test
    fun `Depth calculation`() {
        val dive = Dive(readInput("test/kotlin/resources/Day02.txt"))
        Assert.assertEquals(0, dive.getDepth())
    }

    @Test
    fun `Final depth calculation`() {
        val dive = Dive(readInput("test/kotlin/resources/Day02.txt"))
        Assert.assertEquals(272, dive.getFinalDepth())
    }
}