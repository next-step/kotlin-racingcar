package step2.calculator

enum class OperationType(private val operator: String) {
    PLUS("+") {
        override fun calculate(t: Double, u: Double): Double = t + u
    },
    MINUS("-") {
        override fun calculate(t: Double, u: Double): Double = t - u
    },
    MULTIPLY("*") {
        override fun calculate(t: Double, u: Double): Double = t * u
    },
    DIVIDE("/") {
        override fun calculate(t: Double, u: Double): Double {
            validateDivisor(u)
            return t / u
        }

        private fun validateDivisor(u: Double) {
            if (isZeroDivisor(u)) {
                throw IllegalArgumentException(ZERO_DIVISOR_ERROR_MESSAGE)
            }
        }

        private fun isZeroDivisor(u: Double) = u == 0.0
    };

    abstract fun calculate(t: Double, u: Double): Double

    companion object {
        private const val INVALID_OPERATOR_ERROR_MESSAGE = "옳바르지 않은 연산자입니다. 사칙연산에 해당하는 연산자만 입력하세요 :  %s"
        private const val OPERATION_REGULAR = "^[+\\-*/\\d]*$"
        private const val ZERO_DIVISOR_ERROR_MESSAGE = "0으로 나눌수 없습니다."

        fun match(operator: String): OperationType {
            return values().first { it ->
                it.operator == operator.also { validateOperator(it) }
            }
        }

        private fun validateOperator(operator: String) {
            if (isNotContainOperator(operator)) {
                throw IllegalArgumentException(String.format(INVALID_OPERATOR_ERROR_MESSAGE, operator))
            }
        }

        private fun isContainOperator(operator: String) = Regex(OPERATION_REGULAR).containsMatchIn(operator)
        private fun isNotContainOperator(operator: String) = !isContainOperator(operator)
    }
}
