package step3.view

abstract class InputView {
    fun receive(): Int {
        printInputMessage()
        return receiveUserInput()
    }

    protected abstract fun printInputMessage()

    private fun receiveUserInput(): Int {
        val userInput = requireNotNull(readLine()) {
            INVALID_USER_INPUT_MESSAGE
        }
        return userInput.toInt()
    }

    companion object {
        private const val INVALID_USER_INPUT_MESSAGE = "반드시 값이 입력되어야 합니다."
    }
}