package step2.calculator

import java.util.Arrays

enum class Operator(
    private val operator: String,
) {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

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
