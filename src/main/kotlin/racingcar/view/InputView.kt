package racingcar.view

import racingcar.exception.RacingCarException
import racingcar.exception.RacingCarException.READ_LINE_IS_NOT_POSITIVE_NUM_EXCEPTION

class InputView(
    private val inputLine: () -> String? = {
        readLine()
    }
) {

    fun getNumberOfCars(): Int {
        println(NUMBER_OF_CARS_QUESTION)
        val integerCheckedInput = integerCheck(inputLine())
        require(integerCheckedInput > 0) {
            READ_LINE_IS_NOT_POSITIVE_NUM_EXCEPTION
        }
        return integerCheckedInput
    }

    fun getNumberOfAttempts(): Int {
        println(NUMBER_OF_ATTEMPTS_QUESTION)
        val integerCheckedInput = integerCheck(inputLine())
        require(integerCheckedInput > 0) {
            READ_LINE_IS_NOT_POSITIVE_NUM_EXCEPTION
        }
        return integerCheckedInput
    }

    private fun integerCheck(input: String?): Int {
        return input?.toIntOrNull()
            ?: throw IllegalArgumentException(RacingCarException.READ_LINE_IS_NOT_A_NUMBER_EXCEPTION)
    }

    companion object {
        private const val NUMBER_OF_CARS_QUESTION = "자동차 대수는 몇대인가요?"
        private const val NUMBER_OF_ATTEMPTS_QUESTION = "시도할 횟수는 몇 회인가요?"
    }
}
