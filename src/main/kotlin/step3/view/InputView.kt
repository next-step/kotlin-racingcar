package step3.view

import step3.exception.BizException
import step3.exception.message.input.InputErrorMessage

class InputView(private val value: String = readLine()!!) {

    fun inputNumberOfCars(): Int {
        println(NUMBER_OF_CARS)

        val inputValue: Int = numberCheck(value)

        return valueRangeCheck(inputValue)
    }

    fun inputNumberOfAttempts(): Int {
        println(NUMBER_OF_ATTEMPTS)
        val inputValue: Int = numberCheck(value)

        return valueRangeCheck(inputValue)
    }

    private fun valueRangeCheck(value: Int): Int {
        require(value > 0) { BizException.InputException(InputErrorMessage.OUT_OF_RANGE) }
        return value
    }

    private fun numberCheck(inputValue: String): Int {
        return inputValue.toIntOrNull() ?: throw BizException.InputException(InputErrorMessage.NOT_NUMBER)
    }

    companion object {
        private const val NUMBER_OF_CARS = "자동차 대수는 몇대인가요?"
        private const val NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회 인가요?"
    }
}
