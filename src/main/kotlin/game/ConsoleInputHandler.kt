package game

class ConsoleInputHandler : UserInputHandler {

    override fun askForCarCount(): Int {
        println(CAR_COUNT_QUESTION)
        return readInput().let { InputValidator.validateInput(it); it.toInt() }
    }

    override fun askForRetryCount(): Int {
        println(RETRY_COUNT_QUESTION)
        return readInput().let { InputValidator.validateInput(it); it.toInt() }
    }

    private fun readInput(): String {
        return readlnOrNull() ?: throw IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR_MSG.message)
    }

    companion object {
        private const val CAR_COUNT_QUESTION = "자동차 대수는 몇 대인가요?"
        private const val RETRY_COUNT_QUESTION = "시도할 회수는 몇 회인가요?"
    }
}
