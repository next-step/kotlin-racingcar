package ui

import UserInputType
import util.validInputToInt

class InputView(private val inputProvider: () -> String) {
    fun readUserInput(userInputType: UserInputType): Int {
        println(userInputType.message)
        val inputValue = inputProvider()
        return inputValue.validInputToInt()
    }
}
