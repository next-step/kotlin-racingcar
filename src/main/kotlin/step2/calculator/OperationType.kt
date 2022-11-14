package step2.calculator

enum class OperationType(private val operator: String, val calculate: (Double, Double) -> Double) {
    PLUS("+", { leftOperand, rightOperand ->
        leftOperand + rightOperand
    }),
    MINUS("-", { leftOperand, rightOperand ->
        leftOperand - rightOperand
    }),
    MULTIPLY("*", { leftOperand, rightOperand ->
        leftOperand * rightOperand
    }),
    DIVIDE("/", { leftOperand, rightOperand ->
        validateDivisor(rightOperand)
        leftOperand / rightOperand
    });

    companion object {
        private const val INVALID_OPERATOR_ERROR_MESSAGE = "올바르지 않은 연산자입니다. 사칙연산에 해당하는 연산자만 입력하세요 :  %s"
        private const val ZERO_DIVISOR_ERROR_MESSAGE = "0으로 나눌수 없습니다."
        private const val ZERO_DOT_ZERO = 0.0

        fun match(operator: String): OperationType =
            values().find { it.operator == operator }
                ?: throw IllegalArgumentException(INVALID_OPERATOR_ERROR_MESSAGE.format(operator))

        private fun validateDivisor(divisor: Double) {
            require(divisor != ZERO_DOT_ZERO) { ZERO_DIVISOR_ERROR_MESSAGE }
        }
    }
}
