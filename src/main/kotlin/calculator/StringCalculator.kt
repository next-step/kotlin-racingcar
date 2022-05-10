package calculator

import calculator.util.ExpressionSeparator

class StringCalculator(
    private val expression: String,
) {
    init {
        require(expression.isNotBlank())
    }

    fun calculate(): Int {
        val (numbers, operators) = ExpressionSeparator.separate(expression)

        return operators.operate(numbers.toMutableList())
    }
}
