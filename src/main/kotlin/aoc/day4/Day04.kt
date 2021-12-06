package aoc.day4

import readInput

fun main() {
    val day = "aoc/day4/Day04"

    val giantSquid = GiantSquid(readInput("resources/Day04.txt"))
    println("What will your final score be if you choose that board? " + giantSquid.getFinalScore())
}