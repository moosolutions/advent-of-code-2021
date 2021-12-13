package aoc.day3

import readInput

fun main() {
    val power = BinaryDiagnostic(readInput("main/kotlin/resources/Day03.txt"))
    println("What is the power consumption of the submarine? " + power.getPowerConsumption())

    val power2 = BinaryDiagnostic(readInput("main/kotlin/resources/Day03.txt"))
    println("What is the life support rating of the submarine? " + power2.getLiveSupportRating())
}