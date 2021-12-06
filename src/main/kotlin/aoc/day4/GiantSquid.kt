package aoc.day4

class GiantSquid(input: List<String>) {

    private var winnerNumber: Int
    private lateinit var boards: MutableList<BingoBoard?>
    private lateinit var numbersToCheck: List<Int>
    private val puzzleInput: List<String>
    init {
        this.puzzleInput = input
        this.winnerNumber = -1

        this.boards = MutableList(0) { null }
        // fill boards
        this.puzzleInput.forEachIndexed { index, s ->
            if (index == 0) {
                numbersToCheck = s.split(',').map { it.toInt() }
            } else {
                if (s.isEmpty()) {
                    this.boards.add(BingoBoard())
                } else {
                    this.boards[this.boards.count() - 1]?.addNumbers(s)
                }
            }
        }
    }

    fun checkBoards() : BingoBoard? {
        val winnerBoards = MutableList<BingoBoard>(0) { BingoBoard() }
        for ((idx, number) in this.numbersToCheck.withIndex()) {
            for (item in this.boards) {
                if (!winnerBoards.contains(item)) {
                    item?.mark(number)
                    if (item?.check() == true) {
                        item.winnerNumber = number
                        winnerBoards.add(item)
                    }
                }
            }
        }

//        for (item in winnerBoards) {
//            println(item.getSumOfUnmarkedNumbers() * this.winnerNumber)
//        }

        return winnerBoards.first();
    }

    fun getFinalScore() : Int {
        val bingo = this.checkBoards()
        if (bingo?.found?.count() == 5) {
            return bingo.getSumOfUnmarkedNumbers() * bingo.winnerNumber
        }
        return 0
    }
}