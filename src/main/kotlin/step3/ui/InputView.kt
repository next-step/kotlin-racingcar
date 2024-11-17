package step3.ui

import step3.UserInputType
import step3.UserInputType.NUMBER_OF_CARS
import step3.util.validInputToInt

class InputView(private val inputProvider: () -> String) {
    fun getNumberOfCars(): Int {
        return readUserInput(NUMBER_OF_CARS)
    }

    fun readUserInput(userInputType: UserInputType): Int {
        println(userInputType.message)
        val inputValue = inputProvider()
        return inputValue.validInputToInt()
    }
}
