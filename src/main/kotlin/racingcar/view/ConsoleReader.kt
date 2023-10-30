package racingcar.view

object ConsoleReader {
    fun readInput(): Int {
        val input = readlnOrNull() ?: throw IllegalArgumentException("입력값은 공백이거나 빈 문자열일 수 없습니다.")
        return input.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닌 입력값은 들어올 수 없습니다.")
    }
}