package step2.domain

import step2.model.ErrorCode

data class CalculatorInput(
    val numbers: ArrayDeque<Long>,
    val operators: ArrayDeque<Operator>,
) {

    init {
        val numberSize = numbers.size
        val operatorSize = operators.size

        require(value = numberSize == operatorSize + VALID_RANGE) {
            ErrorCode.INVALID_CALCULATOR_INPUT.message("$numberSize $operatorSize")
        }
    }

    companion object {
        private const val VALID_RANGE: Int = 1
    }
}
