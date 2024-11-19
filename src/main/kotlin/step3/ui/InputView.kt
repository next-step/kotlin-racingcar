package step3.ui

import step3.UserInputType
import step3.UserInputType.ATTEMPT_COUNT
import step3.UserInputType.NUMBER_OF_CARS
import step3.util.validInputToInt

class InputView(private val inputProvider: () -> String) {
    fun getNumberOfCars(): Int {
        return getUserInputOrThrow(NUMBER_OF_CARS)
    }

    fun getAttemptCount(): Int {
        return getUserInputOrThrow(ATTEMPT_COUNT)
    }

    private fun getUserInputOrThrow(userInputType: UserInputType): Int {
        println(userInputType.message)
        val input = inputProvider()
        return input.validInputToInt()
    }
}
