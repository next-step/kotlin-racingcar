package step3.view

class InputView(private val inputMessage: String) {
    fun receive(): Int {
        printInputMessage()
        return receiveUserInput()
    }

    private fun printInputMessage() {
        println(inputMessage)
    }

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