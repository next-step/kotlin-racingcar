package step3.view

import step3.util.InputValidator

class InputView(private val inputMessage: String) {
    fun receive(): Int {
        printInputMessage()
        return receiveUserInput()
    }

    private fun printInputMessage() {
        println(inputMessage)
    }

    private fun receiveUserInput() = InputValidator.validate(readln())
}
