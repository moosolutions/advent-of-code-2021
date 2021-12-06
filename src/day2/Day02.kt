package day2

import readInput

fun main() {
    val diveTest = Dive(readInput("day2/Day02_test"))
    check(diveTest.getDepth() == 0)

    val dive = Dive(readInput("day2/Day02"))
    println("What do you get if you multiply your final horizontal position by your final depth? " + dive.getDepth())

    val dive2Test = Dive(readInput("day2/Day02_test"))
    check(diveTest.getFinalDepth() == 272)

    val dive2 = Dive(readInput("day2/Day02"))
    println("What do you get if you multiply your final horizontal position by your final depth? " + dive2.getFinalDepth())
}