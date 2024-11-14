package study.calculator

import kotlin.collections.ArrayDeque

/**
 * @author 이상준
 */
class StringCalculator {
    fun expressionToArrayDeque(expression: String): ArrayDeque<String> {
        return expression.split(" ").toCollection(ArrayDeque())
    }

    fun validate(expressionArray: ArrayDeque<String>) {
        if (!isNumber(expressionArray.first()) || !isNumber(expressionArray.last())) {
            throw IllegalArgumentException("first or last is Not number..")
        }

        expressionArray.forEachIndexed { index, value ->
            if (index % 2 == 0) {
                if (!isNumber(value)) {
                    throw IllegalArgumentException("$value is Not number..")
                }
                return@forEachIndexed
            }

            if (value !in Operators.entries.toList().map { it.operator }) {
                throw IllegalArgumentException("$value is Not operators..")
            }
        }
    }

    fun expressionCalculate(expression: String): Double {
        val expressionArray = expressionToArrayDeque(expression)
        validate(expressionArray)
        return expressionCalculate(expressionArray)
    }

    private fun expressionCalculate(expressionArray: ArrayDeque<String>): Double {
        var result: Double = expressionArray.removeFirst().toDouble()
        var operator = ""

        while (!expressionArray.isEmpty()) {
            val expression = expressionArray.removeFirst()

            if (expression in Operators.entries.toList().map { it.operator }) {
                operator = expression
            }

            if (isNumber(expression)) {
                result = Operators.findOperator(operator)!!.apply(result, expression.toDouble())
            }
        }

        return result
    }

    private fun isNumber(input: String): Boolean {
        return input.toDoubleOrNull() != null
    }
}

enum class Operators(val operator: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun findOperator(operator: String): Operators? {
            return entries.find { it.operator == operator }
        }
    }

    fun apply(
        num1: Double,
        num2: Double,
    ): Double {
        return when (this) {
            PLUS -> num1 + num2
            MINUS -> num1 - num2
            MULTIPLY -> num1 * num2
            DIVIDE -> num1 / num2
        }
    }
}
