package aoc.day1

import readInput

/*
--- Day 1: Sonar Sweep ---
 */
fun main() {
    var input = readInput("resources/Day01.txt")
    val sonarSweep = SonarSweep(input);
    println("How many measurements are larger than the previous measurement? "
            + sonarSweep.countIncreases() + " of " + input.count())

    input = readInput("aoc/day1/Day01")
    println("How many sums are larger than the previous sum? "
            + sonarSweep.countSlidingWindowIncreases() + " of " + input.count())
}
