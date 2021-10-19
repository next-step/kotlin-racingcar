package racingcar.view

import racingcar.exception.RacingCarException.READ_LINE_IS_NOT_A_NUMBER_EXCEPTION

object InputView {

    private const val NUMBER_OF_CARS_QUESTION = "자동차 대수는 몇대인가요?"
    private const val NUMBER_OF_ATTEMPTS_QUESTION = "시도할 횟수는 몇 회인가요?"

    fun getNumberOfCars(): Int {
        println(NUMBER_OF_CARS_QUESTION)
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(READ_LINE_IS_NOT_A_NUMBER_EXCEPTION)
    }

    fun getNumberOfAttempts(): Int {
        println(NUMBER_OF_ATTEMPTS_QUESTION)
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(READ_LINE_IS_NOT_A_NUMBER_EXCEPTION)
    }
}
