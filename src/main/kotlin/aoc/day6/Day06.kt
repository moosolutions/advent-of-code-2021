package aoc.day6

import aoc.day5.HydrothermalVenture
import readInput

fun main() {
    val lanternfish = Lanternfish(readInput("main/kotlin/resources/Day06.txt"))
    println("How many lanternfish would there be after 80 days? " + lanternfish.getLaternfishCount(80))
    println("How many lanternfish would there be after 256 days? " + lanternfish.getLaternfishCount(256))
}