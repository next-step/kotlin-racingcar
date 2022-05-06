package calculator

import operator.*

class Calculator(
    private val plusOperator: PlusOperator = PlusOperator(),
    private val subtractOperator: SubtractOperator = SubtractOperator(),
    private val divideOperator: DivideOperator = DivideOperator(),
    private val multiplyOperator: MultiplyOperator = MultiplyOperator()
) {

    fun calculate(statement: String): Long {
        val (numbers, operators) = statement.split(" ").partition { isNumeric(it) }
        if (numbers.isEmpty()) {
            throw IllegalArgumentException("number must not be empty.")
        }

        var result = numbers[0].toLong()

        operators.forEachIndexed { index: Int, operator: String ->
            result = getOperator(operator).operate(result, numbers[index + 1].toLong())
        }
        return result
    }

    private fun isNumeric(number: String) = number.all { char -> char.isDigit() }

    private fun getOperator(operator: String): Operator =
        when (operator) {
            "+" -> plusOperator
            "-" -> subtractOperator
            "/" -> divideOperator
            "*" -> multiplyOperator
            else -> throw IllegalArgumentException("This operator is not acceptable. operator: $operator")
        }
}
