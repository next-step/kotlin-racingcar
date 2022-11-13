package racingcar.view

class ConsoleInput {
    fun readCountOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readNotBlankLine()
    }

    fun readRoundsToRace(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readNotBlankLine()
    }

    private fun readNotBlankLine() = readln().ifBlank { throw IllegalArgumentException("empty string is not allowed") }.toInt()
}
