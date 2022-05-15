package calculator

import operator.OperatorFactory

class Calculator(
    private val operatorFactory: OperatorFactory = OperatorFactory()
) {

    fun calculate(statement: String): Long {
        val (numbers, operators) = statement.split(" ").partition { isNumeric(it) }
        if (numbers.isEmpty()) {
            throw IllegalArgumentException("number must not be empty.")
        }

        var result = numbers[0].toLong()

        operators.forEachIndexed { index: Int, operator: String ->
            result = operatorFactory.getOperator(operator).operate(result, numbers[index + 1].toLong())
        }
        return result
    }

    private fun isNumeric(number: String) = number.all { char -> char.isDigit() }
}
