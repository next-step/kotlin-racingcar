package racingCarWinner.view

object ConsoleReader {
    fun readInput(): String {
        return readlnOrNull() ?: throw IllegalArgumentException("입력값은 공백이거나 빈 문자열일 수 없습니다.")
    }
}