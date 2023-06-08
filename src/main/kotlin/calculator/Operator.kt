package calculator

import java.util.function.IntBinaryOperator

enum class Operator(
    private val symbol: String,
    private val operator: IntBinaryOperator
) {
    ADDITION(
        "+", IntBinaryOperator { left, right -> left + right }
    ),
    SUBTRACTION(
        "-", IntBinaryOperator { left, right -> left - right }
    ),
    MULTIPLICATION(
        "*", IntBinaryOperator { left, right -> left * right }
    ),
    DIVISION(
        "/",
        IntBinaryOperator { left, right ->
            if (right == 0) {
                throw IllegalArgumentException("cannot divide by zero")
            }

            left / right
        }
    );

    fun calculate(left: Int, right: Int): Int {
        return operator.applyAsInt(left, right)
    }

    companion object {
        fun findBySymbol(symbol: String): Operator {
            return values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException("not supported operator")
        }
    }
}
