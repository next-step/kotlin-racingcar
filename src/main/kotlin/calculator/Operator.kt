package calculator

import java.util.function.IntBinaryOperator

enum class Operator(
    private val operand: IntBinaryOperator
) {
    ADDITION(
        IntBinaryOperator { left, right -> left + right }
    ),
    SUBTRACTION(
        IntBinaryOperator { left, right -> left - right }
    ),
    MULTIPLICATION(
        IntBinaryOperator { left, right -> left * right }
    ),
    DIVISION(
        IntBinaryOperator { left, right ->
            if (right == 0) {
                throw IllegalArgumentException("cannot divide by zero")
            }

            left / right
        }
    );

    fun calculate(left: Int, right: Int): Int {
        return operand.applyAsInt(left, right)
    }
}
