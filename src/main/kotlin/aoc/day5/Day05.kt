package aoc.day5

import readInput

fun main() {
    val hydroVents = HydrothermalVenture(readInput("main/kotlin/resources/Day05.txt"))
    println("At how many points do at least two lines overlap? " + hydroVents.getOverlappingLinesCount())
    println("At how many points do at least two lines overlap (with diagonal lines)? " + hydroVents.getOverlappingLinesCountWithDiagonalLines())
}