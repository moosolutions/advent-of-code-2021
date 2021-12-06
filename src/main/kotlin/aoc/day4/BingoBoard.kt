package aoc.day4

class BingoBoard {
    fun addNumbers(numbers: String) {
        numbers.split(' ').forEach {
            if (!it.isEmpty())
                this.board.add(it.toInt())
        }
    }

    fun mark(number: Int) {
        this.board.forEachIndexed { index, i ->
            if (i == number) {
                this.states[index] = true
            }
        }
    }

    fun check() : Boolean {
        val steps = 5
        // check rows
        var rows = this.states
            .filterIndexed { index, b ->
                (index % steps) == 0 && b || b && index == 0
            }
            .mapIndexed { index, b -> index }
        for (idx in rows) {
            found.clear()
            for (i in idx until idx + 5) {
                if (this.states[i]) {
                    found.add(this.board[i])
                } else {
                    found.clear()
                    break
                }
            }
            if (found.count() == 5) {
                return true
            }
        }

        // check columns
        for (i in 0 until steps) {
            found.clear()
            if (this.states[i]) {
                found.add(this.board[i])
                val column = this.states
                    .filterIndexed { index, b -> (index % (steps + i)) == 0  }
                    .mapIndexed { index, b -> index }
                for (col in column) {
                    if (this.states[col]) {
                        found.add(this.board[col])
                    } else {
                        found.clear()
                    }
                }
                if (found.count() == 5) {
                    return true
                }
            }
        }

        return false
    }

    fun getSumOfUnmarkedNumbers(): Int {
        for ((idx, item) in this.states.withIndex()) {
            if (!item) {
                this.unmarkedNumbers[idx] = this.board[idx]
            }
        }
        return this.unmarkedNumbers.sum()
    }

    var winnerNumber = -1
    val unmarkedNumbers = MutableList(25) { 0 }
    val found = MutableList(0) { 0 }
    val board = MutableList(0) { 0 }
    val states = MutableList(25) { false }
}