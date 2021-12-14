package aoc.day6

class Lanternfish(var input: List<String>) {
    fun getLaternfishCount(afterDays: Int): Long {
        var lanternfishes = input
            .first()
            .split(",")
            .map {
                it.toInt()
            }
            .toList()
            .groupingBy { it }
            .eachCount()

        // My own solution was very slow, after searching I found a faster solution on GitHub
        // https://github.com/aormsby/advent-of-code-2021/blob/main/src/main/kotlin/d6_Lanternfish/Lanternfish.kt
        // thx to the author
        var lanternfishPool = mutableMapOf(
            0 to 0L, 1 to 0L, 2 to 0L, 3 to 0L,
            4 to 0L, 5 to 0L, 6 to 0L, 7 to 0L, 8 to 0L
        )

        lanternfishes.forEach {
            lanternfishPool[it.key] = it.value.toLong()
        }

        for (i in 1..afterDays) {
            val respawnFish = lanternfishPool[0]!!

            lanternfishPool.keys.forEach {
                if (it != 0) {
                    lanternfishPool[it - 1] = lanternfishPool[it]!!
                }
            }

            lanternfishPool[8] = respawnFish
            lanternfishPool.merge(6, respawnFish) { a, b -> a + b }
        }
        return lanternfishPool.values.sum()
    }
}