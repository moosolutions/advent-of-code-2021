package day1

import readInput

/*
--- Day 1: Sonar Sweep ---
 */
fun main() {
    val sonarSweepTest = SonarSweep(readInput("day1/Day01_test"));
    check(sonarSweepTest.countIncreases() == 11)

    var input = readInput("day1/Day01")
    val sonarSweep = SonarSweep(input);
    println("Test: " + sonarSweepTest.countIncreases());
    println("How many measurements are larger than the previous measurement? " + sonarSweep.countIncreases() + " of " + input.count())

    val slidingWindowTest = SonarSweep(readInput("day1/Day01_test"));
    println("Test: " + sonarSweepTest.countSlidingWindowIncreases());
    check(sonarSweepTest.countSlidingWindowIncreases() == 10)

    input = readInput("day1/Day01")
    val slidingWindow = SonarSweep(input);
    println("Test: " + sonarSweepTest.countSlidingWindowIncreases());
    println("How many sums are larger than the previous sum? " + sonarSweep.countSlidingWindowIncreases() + " of " + input.count())
}
