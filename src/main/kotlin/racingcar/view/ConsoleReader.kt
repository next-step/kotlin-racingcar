package racingcar.view

object ConsoleReader {
    fun readInput(): Int {
        val input = readlnOrNull() ?: throw IllegalArgumentException("입력값은 공백이거나 빈 문자열일 수 없습니다.")
        val inputNum: Int
        try {
            inputNum = input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력값은 0 이상의 숫자여야 합니다.")
        }
        return inputNum
    }
}