package aoc.day2

import readInput

fun main() {
    val dive = Dive(readInput("aoc/day2/Day02"))
    println("What do you get if you multiply your final horizontal position by your final depth? " + dive.getDepth())

    val dive2 = Dive(readInput("aoc/day2/Day02"))
    println("What do you get if you multiply your final horizontal position by your final depth? " + dive2.getFinalDepth())
}