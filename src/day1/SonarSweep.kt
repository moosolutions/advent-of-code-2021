package day1

class SonarSweep(val measurements: List<String>) {
    fun countIncreases() : Int
    {
        var prevMeasurement: Int = -1
        var countIncreases: Int = 0
        measurements.forEach {
            if (prevMeasurement !== -1) {
                if (it.toInt() > prevMeasurement) {
                    countIncreases++
                }
            }
            prevMeasurement = it.toInt()
        }
        return countIncreases
    }

    fun countSlidingWindowIncreases(): Int
    {
        var countIncreases: Int = 0
        val slidingWindows = measurements.map { it.toInt() }
        for ((index, value) in slidingWindows.withIndex()) {
            if (index+3 < slidingWindows.count()) {
                val windowOne = slidingWindows.slice(index..index + 2)
                val windowTwo = slidingWindows.slice(index + 1..index + 3)
                if (windowOne.sum() < windowTwo.sum()) {
                    countIncreases++
                }
            }
        }
        return countIncreases
    }
}