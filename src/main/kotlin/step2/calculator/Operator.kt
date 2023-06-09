package step2.calculator

import java.util.function.BiFunction

enum class Operator(
    private val symbol: String,
    private val operation: BiFunction<Int, Int, Int>
) {
    PLUS("+", { op1, op2 -> op1 + op2 }),
    MINUS("-", { op1, op2 -> op1 - op2 }),
    MULTIPLY("*", { op1, op2 -> op1 * op2 }),
    DIVIDE("/", { op1, op2 ->
        if (op2 == 0) {
            throw IllegalArgumentException()
        }
        op1 / op2
    });

    fun operate(op1: Int, op2: Int) = operation.apply(op1, op2)

    companion object {
        fun findOperator(symbol: String): Operator =
            values().find { it.symbol == symbol } ?: throw IllegalArgumentException("올바른 기호가 아닙니다.")
    }
}
