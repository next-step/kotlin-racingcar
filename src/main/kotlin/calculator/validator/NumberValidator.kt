package calculator.validator

import calculator.enums.ErrorMessages.INVALID_NUMBER_INPUT_EXCEPTION

object NumberValidator {
    fun validateNumber(value: String): Int {
        return try {
            value.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_NUMBER_INPUT_EXCEPTION.message)
        }
    }
}
