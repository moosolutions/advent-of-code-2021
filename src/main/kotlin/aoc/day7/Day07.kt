package aoc.day7

import readInput

fun main() {
    val input = readInput("main/kotlin/resources/Day07.txt")
    val whale = TreacheryOfWhale(input.first().split(',').map { it.toInt() })

    println("How much fuel must they spend to align to that position? " + whale.getFuelToSpend(true))
    println("How much fuel must they spend to align to that position? " + whale.getFuelToSpend(false))
}