package calculator.validator

import calculator.exception.ErrorMessages.INVALID_INPUT_EXCEPTION

object InputValidator {
    private const val MINIMUM_VALUE = 3

    fun validateInput(input: String?): String {
        require(!input.isNullOrEmpty()) { INVALID_INPUT_EXCEPTION.message }

        return input
    }

    fun validateSize(numbersSize: Int, operatorsSize: Int) {
        require(isNumbersSizeEven(numbersSize)) { INVALID_INPUT_EXCEPTION.message }
        require(isNumberOneMoreThanOperator(numbersSize, operatorsSize)) { INVALID_INPUT_EXCEPTION.message }
        require(exceedsMinimumValue(numbersSize + operatorsSize)) { INVALID_INPUT_EXCEPTION.message }
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
