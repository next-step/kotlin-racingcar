package study.calculator

import kotlin.collections.ArrayDeque

/**
 * @author 이상준
 */
class StringCalculator {
    fun expressionToArrayDequeue(expression: String): ArrayDeque<String> {
        return expression.split(" ").toCollection(ArrayDeque())
    }

    fun validate(expressionArray: ArrayDeque<String>) {
        if (!isNumber(expressionArray.first()) || !isNumber(expressionArray.last())) {
            throw IllegalArgumentException("first or last is Not number..")
        }

        var temp = 0
        expressionArray.forEach {
            if (temp == 0) {
                if (!isNumber(it)) {
                    throw IllegalArgumentException("$it is Not number..")
                }

                temp = 1
            } else {
                if (it !in listOf(Operators.PLUS, Operators.MINUS, Operators.MULTIPLY, Operators.DIVIDE)) {
                    throw IllegalArgumentException("$it is Not operators..")
                }

                temp = 0
            }
        }
    }

    private fun calculate(
        num1: Double,
        num2: Double,
        operator: String,
    ): Double {
        return when (operator) {
            Operators.PLUS -> plus(num1, num2)
            Operators.MINUS -> minus(num1, num2)
            Operators.MULTIPLY -> multiply(num1, num2)
            Operators.DIVIDE -> divide(num1, num2)
            else -> throw IllegalArgumentException("Invalid operator.")
        }
    }

    fun expressionCalculate(expression: String): Double {
        val expressionArray = expressionToArrayDequeue(expression)
        validate(expressionArray)
        return expressionCalculate(expressionArray)
    }

    private fun expressionCalculate(expressionArray: ArrayDeque<String>): Double {
        var result: Double = expressionArray.removeFirst().toDouble()
        var operator = ""

        while (!expressionArray.isEmpty()) {
            val expression = expressionArray.removeFirst()

            if (expression in listOf(Operators.PLUS, Operators.MINUS, Operators.MULTIPLY, Operators.DIVIDE)) {
                operator = expression
            }

            if (isNumber(expression)) {
                result =
                    calculate(
                        num1 = result,
                        num2 = expression.toDouble(),
                        operator = operator,
                    )
            }
        }

        return result
    }

    private fun plus(
        num1: Double,
        num2: Double,
    ): Double {
        return num1 + num2
    }

    private fun minus(
        num1: Double,
        num2: Double,
    ): Double {
        return num1 - num2
    }

    private fun multiply(
        num1: Double,
        num2: Double,
    ): Double {
        return num1 * num2
    }

    private fun divide(
        num1: Double,
        num2: Double,
    ): Double {
        return num1 / num2
    }

    private fun isNumber(input: String): Boolean {
        return input.toDoubleOrNull() != null
    }
}

object Operators {
    const val PLUS = "+"
    const val MINUS = "-"
    const val MULTIPLY = "*"
    const val DIVIDE = "/"
}
