package calculator.util

import calculator.Operator
import calculator.Operators

private const val EXPRESSION_DELIMITER = " "
private const val EVEN_AND_ODD_STANDARD = 2
private const val NUMBER_POSITION = 0

object ExpressionSeparator {
    fun separate(expression: String): Pair<List<Int>, Operators> {
        val separatedComponents = expression.split(EXPRESSION_DELIMITER)
            .withIndex()
            .partition { it.index % EVEN_AND_ODD_STANDARD == NUMBER_POSITION }

        val numbers = separatedComponents.first.map { it.value.toInt() }
        val operators = Operators(separatedComponents.second.map { Operator.of(it.value) })

        return numbers to operators
    }
}
