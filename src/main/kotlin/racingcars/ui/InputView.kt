package racingcars.ui

import racingcars.UserInputType
import racingcars.UserInputType.ATTEMPT_COUNT
import racingcars.UserInputType.NUMBER_OF_CARS
import racingcars.util.validInputToInt

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
