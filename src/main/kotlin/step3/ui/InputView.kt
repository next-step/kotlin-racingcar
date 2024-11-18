package step3.ui

import step3.UserInputType
import step3.UserInputType.NUMBER_OF_CARS
import step3.util.validInputToInt

class InputView(private val inputProvider: () -> String) {
    fun getNumberOfCars(): Int {
        val userInput = readUserInput(NUMBER_OF_CARS)
        return validateUserInput(userInput)
    }

    fun readUserInput(userInputType: UserInputType): String? {
        println(userInputType.message)
        return inputProvider()
    }

    fun validateUserInput(input: String?): Int {
        return input.validInputToInt()
    }
}
