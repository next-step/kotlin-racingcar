package racingcar.validator

import racingcar.exception.ErrorMessages.INVALID_NUMBER_INPUT_EXCEPTION
import racingcar.exception.ErrorMessages.INVALID_NUMBER_RANGE_EXCEPTION

class InputValidator {
    companion object {
        fun validateInput(input: String): Int {
            return try {
                val number = input.toInt()
                require(isPositive(number)) { INVALID_NUMBER_RANGE_EXCEPTION.message }
                number
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(INVALID_NUMBER_INPUT_EXCEPTION.message)
            }
        }

        private fun isPositive(input: Int): Boolean {
            return input > 0
        }
    }
}
