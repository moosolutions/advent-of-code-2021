package aoc.day3

class BinaryDiagnostic(val diagnosticReport: List<String>) {
    fun getPowerConsumption() : Int {
        val gamaRate = MutableList(diagnosticReport[0].length) { 0 }
        val epsilonRate = MutableList(diagnosticReport[0].length) { 0 }
        val highBit = MutableList(diagnosticReport[0].length) { 0 }
        val lowBit = MutableList(diagnosticReport[0].length) { 0 }
        diagnosticReport.forEach {
            it.forEachIndexed { index, char ->
                if (char.code == 49) {
                    highBit[index] += 1
                } else {
                    lowBit[index] += 1
                }
            }
        }

        highBit.forEachIndexed { index, i ->
            if (lowBit[index] < i) {
                gamaRate[index] = 1
                epsilonRate[index] = 0
            } else {
                gamaRate[index] = 0
                epsilonRate[index] = 1
            }
        }

        return Integer.parseInt(gamaRate.joinToString(""), 2) *
                Integer.parseInt(epsilonRate.joinToString(""), 2)
    }

    fun getLiveSupportRating() : Int {
        lastOxygenItem = getOxygenGeneratorRating(0, diagnosticReport)
        lastCO2ScrubberItem = getCO2ScrubberRating(0, diagnosticReport)

        return Integer.parseInt(lastOxygenItem, 2) *
                Integer.parseInt(lastCO2ScrubberItem, 2)
    }

    var lastOxygenItem = ""
    fun getOxygenGeneratorRating(index: Int, filteredDiagnosticReport: List<String>) : String {
        val one = filteredDiagnosticReport.filter { it[index].code == 49 }
        val zero = filteredDiagnosticReport.filter { it[index].code == 48 }

        if (one.count() >= zero.count()) {
            if (one.count() == 1) {
                return one[0]
            }
            lastOxygenItem = getOxygenGeneratorRating(index + 1, one)
        } else {
            if (zero.count() == 1) {
                return zero[0]
            }
            lastOxygenItem = getOxygenGeneratorRating(index + 1, zero)
        }

        return lastOxygenItem
    }

    var lastCO2ScrubberItem = ""
    fun getCO2ScrubberRating(index: Int, filteredDiagnosticReport: List<String>) : String {
        val one = filteredDiagnosticReport.filter { it[index].code == 49 }
        val zero = filteredDiagnosticReport.filter { it[index].code == 48 }

        if (zero.count() >= one.count()) {
            if (zero.count() == 1) {
                return zero[0]
            }
            lastCO2ScrubberItem = getCO2ScrubberRating(index + 1, zero)
        } else {
            if (one.count() == 1) {
                return one[0]
            }
            lastCO2ScrubberItem = getCO2ScrubberRating(index + 1, one)
        }
        return lastCO2ScrubberItem
    }
}