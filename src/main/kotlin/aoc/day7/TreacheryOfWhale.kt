package aoc.day7

import kotlin.math.abs

class TreacheryOfWhale(val input: List<Int>) {
    fun getFuelToSpend(constantRate: Boolean): Int {
        val min = input.minOrNull() ?: 0
        val max = input.maxOrNull() ?: 0

        return (min..max).minOfOrNull {
            input.sumOf { i ->
                val n = abs(it - i)
                if (constantRate) {
                    n
                } else {
                    n * (n + 1) / 2
                }
            }
        } ?: 0
    }
}