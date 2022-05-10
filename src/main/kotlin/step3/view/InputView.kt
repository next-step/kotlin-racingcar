package step3.view

import step3.util.InputNumberRangeValidator

class InputView(private val inputMessage: String) {
    fun receive(): Int {
        printInputMessage()
        return receiveUserInput()
    }

    private fun printInputMessage() {
        println(inputMessage)
    }

    private fun receiveUserInput() = InputNumberRangeValidator.validate(readln().toInt())
}
