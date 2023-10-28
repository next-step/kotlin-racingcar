package study.calculator

import study.calculator.Expression.Operator.Companion.convertToOperator
import study.util.requireAndPass

class Expression(private val operatorToken: String, private val numberToken: String) {
    val operator: Operator = convertToOperator(operatorToken)

    val number: Int = numberToken.toIntOrNull()
        ?: throw IllegalArgumentException("Invalid numberToken")

    companion object {
        fun convertToExpressions(flattenedExpressions: String): List<Expression> =
            flattenedExpressions
                .split(' ')
                .requireAndPass({ it.size % 2 != 0 }) { "Invalid number of tokens" }
                .let { listOf<String>("+", *it.toTypedArray()) }
                .chunked(2)
                .map { Expression(it[0], it[1]) }
    }

    enum class Operator(
        val evaluate: (Int, Int) -> Int
    ) {
        ADD({ number1, number2 -> number1 + number2 }),
        SUBTRACT({ number1, number2 -> number1 - number2 }),
        MULTIPLY({ number1, number2 -> number1 * number2 }),
        DIVIDE({ number1, number2 -> number1 / number2 });

        companion object {
            fun convertToOperator(operatorToken: String) = when (operatorToken) {
                "+" -> Operator.ADD
                "-" -> Operator.SUBTRACT
                "*" -> Operator.MULTIPLY
                "/" -> Operator.DIVIDE
                else -> throw IllegalArgumentException("Invalid operatorToken")
            }
        }
    }
}
