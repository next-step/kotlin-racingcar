package calculator.validator

import calculator.enums.ErrorMessages.INVALID_INPUT_EXCEPTION
import calculator.enums.Operators

object InputValidator {
    private const val MINIMUM_VALUE = 3

    fun validateInput(input: String?): String {
        require(!input.isNullOrEmpty()) { INVALID_INPUT_EXCEPTION.message }

        return input
    }

    fun validateSize(numbers: List<Int>, operators: List<Operators>) {
        require(isNumbersSizeEven(numbers.size)) { INVALID_INPUT_EXCEPTION.message }
        require(isNumberOneMoreThanOperator(numbers.size, operators.size)) { INVALID_INPUT_EXCEPTION.message }
        require(exceedsMinimumValue(numbers.size + operators.size)) { INVALID_INPUT_EXCEPTION.message }
    }

    private fun isNumbersSizeEven(size: Int): Boolean {
        return size % 2 == 0
    }

    private fun isNumberOneMoreThanOperator(numberSize: Int, operatorSize: Int): Boolean {
        return numberSize - 1 == operatorSize
    }

    private fun exceedsMinimumValue(size: Int): Boolean {
        return size >= MINIMUM_VALUE
    }
}
