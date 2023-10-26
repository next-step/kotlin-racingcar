package game

object ConsoleInputReader {
    fun readInput(): String {
        return readlnOrNull() ?: throw IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR_MSG.message)
    }
}
