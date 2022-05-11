package racinggame.view

import racinggame.view.validator.NumberRangeValidator

class InputView(private val inputMessage: String) {
    fun receive(): Int {
        printInputMessage()
        return receiveUserInput()
    }

    private fun printInputMessage() {
        println(inputMessage)
    }

    private fun receiveUserInput() = NumberRangeValidator.validate(readln().toInt())
}
