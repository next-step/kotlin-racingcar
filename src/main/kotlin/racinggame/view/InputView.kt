package racinggame.view

import racinggame.util.InputNumberRangeValidator

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
