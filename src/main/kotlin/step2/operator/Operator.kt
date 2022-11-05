package step2.operator

import step2.ErrorMessage

enum class Operator(
    private val operationFunction: (Int, Int) -> Int
) : BinaryOperator<Int> {
    PLUS(Int::plus),
    MINUS(Int::minus),
    TIMES(Int::times),
    DIV(Int::div),
    REM(Int::rem);

    companion object {
        private const val PLUS_OPERATOR_STRING = "+"
        private const val MINUS_OPERATOR_STRING = "-"
        private const val TIMES_OPERATOR_STRING = "*"
        private const val DIV_OPERATOR_STRING = "/"
        private const val REM_OPERATOR_STRING = "%"

        fun of(operator: String): Operator = when (operator) {
            PLUS_OPERATOR_STRING -> PLUS
            MINUS_OPERATOR_STRING -> MINUS
            TIMES_OPERATOR_STRING -> TIMES
            DIV_OPERATOR_STRING -> DIV
            REM_OPERATOR_STRING -> REM
            else -> throw IllegalArgumentException("${ErrorMessage.INVALID_OPERATOR} [$operator]")
        }
    }

    override fun operate(left: Int, right: Int): Int = operationFunction(left, right)
}
