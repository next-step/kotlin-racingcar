package string.calculator.part

import string.calculator.enum.Operator

class Validator {
    fun validateInput(numbers: MutableList<Long>, operators: MutableList<Operator>) {
        require(numbers.isNotEmpty()) { throw IllegalArgumentException(NUMBER_NOT_ENTERED) }
        require(operators.isNotEmpty()) { throw IllegalArgumentException(OPERATOR_NOT_ENTERED) }
        require(numbers.size != 1) { throw IllegalArgumentException(ONLY_ONE_NUMBER_ENTERED) }
        require(numbers.size == operators.size + 1) { throw IllegalArgumentException(INPUT_IS_NOT_VALID) }
    }

    fun validateContinue(input: String) {
        require(input == "Y" || input == "N") { throw IllegalArgumentException(CONTINUE_IS_NOT_VALID) }
    }

    companion object {
        const val NUMBER_NOT_ENTERED = "숫자가 입력되지 않았습니다."
        const val OPERATOR_NOT_ENTERED = "연산자가 입력되지 않았습니다."
        const val ONLY_ONE_NUMBER_ENTERED = "숫자가 하나만 입력되었습니다."
        const val INPUT_IS_NOT_VALID = "입력값이 올바르지 않습니다."
        const val CONTINUE_IS_NOT_VALID = "계속 여부는 Y 또는 N만 입력 가능합니다."
    }
}
