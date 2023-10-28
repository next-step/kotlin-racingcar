package game

class ConsoleInputHandler : UserInputHandler {

    override fun askForCarNames(): String {
        println(CAR_NAMES_QUESTION)
        return readInput()
    }

    override fun askForRetryCount(): Int {
        println(RETRY_COUNT_QUESTION)
        return readInput().let { InputValidator.validateInput(it); it.toInt() }
    }

    private fun readInput(): String {
        return readlnOrNull() ?: throw IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR_MSG.message)
    }

    companion object {
        private const val CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val RETRY_COUNT_QUESTION = "시도할 회수는 몇 회인가요?"
    }
}
