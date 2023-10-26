package calculator.validator

import calculator.enums.ErrorMessages.INVALID_OPERATOR_EXCEPTION
import calculator.enums.Operators

object OperatorValidator {
    private const val OPERATOR_REGEX = "^[0-9+\\-/* ]+\$"

    fun validateOperator(value: String): Operators {
        require(value.matches(Regex(OPERATOR_REGEX))) {
            INVALID_OPERATOR_EXCEPTION.message
        }
        return Operators.findValue(value)
    }
}
