package aoc.day4

import java.util.stream.Collectors
import java.util.stream.IntStream

class BingoGame(input: List<String>) {
    private var numbers = mutableListOf<Int>()
    private var boards = mutableListOf<Board>()
    public var winningBoards = mutableListOf<Board>()
    init {
        numbers = input
            .first()
            .split(',')
            .map {
                it.toInt()
            }.toMutableList()

        input
            .drop(1)
            .filter { it.isNotEmpty() }
            .windowed(5, 5)
            .map {
                it.map { row ->
                    row
                        .split(' ')
                        .filter { s -> s.isNotEmpty() }
                        .map { n -> Cell(n.toInt())}
                        .toList()
                }
            }
            .map { it ->
                var b = Board(it)
                b.columns = Board.transpose(it)
                this.boards.add(b)
            }
    }

    fun play() {
        numbers.forEachIndexed { idx, number ->
            this.boards.forEach {
                it.mark(number)
                if (it.check() && !this.winningBoards.contains(it)) {
                    it.winningNumber = number
                    winningBoards.add(it)
                }
            }
        }
    }
}

class Board(val rows: List<List<Cell>>) {
    public var columns = listOf<List<Cell>>()
    public var won = false
    public var winningNumber = -1
    companion object {
        fun <T> transpose(list: List<List<T>>): List<List<T>> {
            val N = list.stream().mapToInt { l: List<T> -> l.size }.max().orElse(-1)
            val iterList = list.stream().map { it: List<T> -> it.iterator() }
                .collect(Collectors.toList())
            return IntStream.range(0, N)
                .mapToObj { n: Int ->
                    iterList.stream()
                        .filter { it: Iterator<T> -> it.hasNext() }
                        .map { m: Iterator<T> -> m.next() }
                        .collect(Collectors.toList())
                }
                .collect(Collectors.toList())
        }
    }

    fun finalScore(): Int {
        var sum = 0;
        this.rows.forEach { sum += it.filter { !it.marked }.map { it.number }.toMutableList().sum() }
        return sum * this.winningNumber
    }

    fun mark(number: Int) {
        if (!this.won) {
            this.rows.forEach { it.find { it.number == number }?.mark() }
        }
    }

    fun check(): Boolean {
        if(this.rows.any { it.count { it.marked } == 5 }) {
            this.won = true
        } else if (this.columns.any { it.count { it.marked } == 5 }) {
            this.won = true
        }
        return this.won
    }
}

class Cell(public var number: Int) {
    public var marked = false

    fun mark() {
        this.marked = true
    }
}