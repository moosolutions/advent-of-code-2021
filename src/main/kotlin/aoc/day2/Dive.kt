package aoc.day2

class Dive(val commands: List<String>) {

    fun getDepth() : Int {
        var depth = 0
        var forward = 0

        commands.forEach {
            val command = it.split(' ')
            if (command[0] == "forward") {
                forward += command[1].toInt()
            } else if(command[0] == "down") {
                depth += command[1].toInt()
            } else if (command[0] == "up") {
                depth -= command[1].toInt()
            }
        }
        return depth * forward
    }

    fun getFinalDepth() : Int {
        var aim = 0
        var depth = 0
        var forward = 0

        commands.forEach {
            val command = it.split(' ')
            if (command[0] == "forward") {
                val f = command[1].toInt()
                forward += f
                depth += aim * f
            } else if(command[0] == "down") {
                aim += command[1].toInt()
            } else if (command[0] == "up") {
                aim -= command[1].toInt()
            }
        }
        return depth * forward
    }

}