package calculator

import calculator.ExpressionParser.parse

class Expressions(input: String) {
    private val operands: List<Operand>
    private val operators: List<Operator>

    init {
        val splittedInput = input.split(DELIMITER)
        operands = splittedInput.parse(Operand.isOrderOf, Operand.CONVERT_TO_OPERAND)
        operators = splittedInput.parse(Operator.isOrderOf, Operator.convertToOperator)
        require(operands.size - operators.size == DIFFERENCE_NUMBER_OF_OPERANDS_AND_OPERATORS) {
            "피연산자는 연산자보다 하나 더 많아야 합니다"
        }
    }

    companion object {
        private const val DELIMITER = " "
        private const val DIFFERENCE_NUMBER_OF_OPERANDS_AND_OPERATORS = 1
    }
}
