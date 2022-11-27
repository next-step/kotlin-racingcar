package calculator.domain

import calculator.extenstion.isNotInt

private const val EMPTY_OPERATOR = ""

object Calculator {
    tailrec fun calculate(expression: MutableList<String>, accumulator: Int = expression.removeFirst().toInt(), operator: String = EMPTY_OPERATOR): Int {
        if (expression.isEmpty()) {
            return accumulator
        }

        return when {
            expression.first().isNotInt() -> calculate(expression = expression, accumulator = accumulator, operator = expression.removeFirst())
            else -> calculate(expression = expression, accumulator = Operator.calculate(accumulator, operator, expression.removeFirst().toInt()), operator = EMPTY_OPERATOR)
        }
    }
}

enum class Operator(
    private val operator: String,
    private val calculator: (Int, Int) -> Int
) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLY("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 -> num1 / num2 });

    companion object {
        fun calculate(num1: Int, operator: String, num2: Int): Int {
            val operatorObject = values().firstOrNull { it.operator == operator } ?: throw IllegalArgumentException("$operator is invalid operator")
            return operatorObject.calculator(num1, num2)
        }
    }
}
