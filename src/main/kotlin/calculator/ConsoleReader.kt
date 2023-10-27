package calculator

object ConsoleReader {
    fun readInput(): String {
        return readlnOrNull() ?: throw IllegalArgumentException("입력값은 null일 수 없습니다.")
    }
}