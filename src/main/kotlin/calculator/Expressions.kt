package calculator

import calculator.ExpressionParser.Companion.parse

class Expressions(input: String) {
    private val numbers: List<Number>
    private val operators: List<Operator>

    init {
        val splittedInput = input.split(DELIMITER)
        numbers = splittedInput.parse(Number.isOrderOf, Number.convertToNumber)
        operators = splittedInput.parse(Operator.isOrderOf, Operator.convertToOperator)
    }

    companion object {
        private const val DELIMITER = " "
    }
}
