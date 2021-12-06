package test.kotlin.aoc.day1

import aoc.day1.SonarSweep
import org.junit.Assert
import org.junit.Test
import readInput

class Day01Test {

    @Test
    fun `Count measurement increases`() {
        val sonarSweep = SonarSweep(readInput("test/kotlin/resources/Day01.txt"))
        Assert.assertEquals(11, sonarSweep.countIncreases())
    }

    @Test
    fun `Count sliding windows`() {
        val slidingWindow = SonarSweep(readInput("test/kotlin/resources/Day01.txt"));
        Assert.assertEquals(10, slidingWindow.countSlidingWindowIncreases())
    }
}