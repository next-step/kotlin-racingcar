package step2.calculator

import java.util.Arrays
import java.util.function.IntBinaryOperator

enum class Operator(
    private val operator: String,
    private val expression: IntBinaryOperator
) {
    ADDITION(
        "+",
        IntBinaryOperator { firstOperand: Int, secondOperand: Int ->
            firstOperand + secondOperand
        }
    ),
    SUBTRACTION(
        "-",
        IntBinaryOperator { firstOperand: Int, secondOperand: Int ->
            firstOperand - secondOperand
        }
    ),
    MULTIPLICATION(
        "*",
        IntBinaryOperator { firstOperand: Int, secondOperand: Int ->
            firstOperand * secondOperand
        }
    ),
    DIVISION(
        "/",
        IntBinaryOperator { firstOperand: Int, secondOperand: Int ->
            firstOperand / secondOperand
        }
    );

    @Throws(ArithmeticException::class)
    fun calculate(firstOperand: Int, secondOperand: Int) = this.expression.applyAsInt(firstOperand, secondOperand)

    companion object {
        const val INVALID_OPERATOR_ERROR_MESSAGE = "Given operator is not valid"

        @JvmStatic
        fun getOperator(operator: String): Operator {
            return Arrays.stream(values())
                .filter { op ->
                    op.operator == operator
                }
                .findFirst()
                .orElseThrow {
                    IllegalArgumentException(INVALID_OPERATOR_ERROR_MESSAGE)
                }
        }
    }
}
