package aoc.day5

import java.awt.font.NumericShaper
import java.util.stream.IntStream

class HydrothermalVenture(var linesOfVent: List<String>) {
    var arrSize = linesOfVent
        .map {
            it.split(" -> ")
                .map {
                        n -> n
                    .split(",")
                    .map { s -> s.toInt() }
                }
                .flatten()
        }
        .flatten()
        .maxOrNull()

    fun getOverlappingLinesCount() : Int {
        var grid = Array(arrSize?.plus(1) ?: 0) { IntArray(arrSize?.plus(1) ?: 0) }
        linesOfVent.forEach { it ->
            val x1y1 = it.split(" ").first().split(",").map { n -> n.toInt() }
            val x2y2 = it.split(" ").last().split(",").map { n -> n.toInt() }
            if (x1y1[0] == x2y2[0]) {
                for (y in minOf(x1y1[1], x2y2[1])  .. maxOf(x1y1[1], x2y2[1])) {
                    grid[y][x1y1[0]]++
                }
            } else if (x1y1[1] == x2y2[1]) {
                for (x in minOf(x1y1[0], x2y2[0])  .. maxOf(x1y1[0], x2y2[0])) {
                    grid[x1y1[1]][x]++
                }
            }
        }
        return grid.sumOf { it.filter { n -> n > 1 }.count() }
    }

    fun getOverlappingLinesCountWithDiagonalLines() : Int {
        var grid = Array(arrSize?.plus(1) ?: 0) { IntArray(arrSize?.plus(1) ?: 0) }
        linesOfVent.forEach { it ->
            val x1y1 = it.split(" ").first().split(",").map { n -> n.toInt() }
            val x2y2 = it.split(" ").last().split(",").map { n -> n.toInt() }

            if (x1y1[0] == x2y2[0]) {
                for (y in minOf(x1y1[1], x2y2[1])  .. maxOf(x1y1[1], x2y2[1])) {
                    grid[y][x1y1[0]]++
                }
            } else if (x1y1[1] == x2y2[1]) {
                for (x in minOf(x1y1[0], x2y2[0])  .. maxOf(x1y1[0], x2y2[0])) {
                    grid[x1y1[1]][x]++
                }
            } else {
                var rangeX = getRange(x1y1[0], x2y2[0])
                var rangeY = getRange(x1y1[1], x2y2[1])
                for ((idx, x) in rangeX.withIndex()) {
                    grid[rangeY.toMutableList()[idx]][x]++
                }
            }
        }
        return grid.sumOf { it.filter { n -> n > 1 }.count() }
    }

    private fun getRange(from: Int, to: Int): IntProgression {
        return if (from > to) {
            from downTo to
        } else {
            from .. to
        }
    }
}