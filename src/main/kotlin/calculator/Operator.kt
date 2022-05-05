package calculator

enum class Operator(val stringValue: String, val calcLogic: (a: Double, b: Double) -> Double) {
    PLUS("+", { a, b ->
        a + b
    }),
    MINUS("-", { a, b ->
        a - b
    }),
    DIVIDE("/", { a, b ->
        a / b
    }),
    MULTIPLY("*", { a, b ->
        a * b
    });

    companion object {
        private const val WRONG_OPERATOR_ERROR_MSG = "wrong operator conversion"

        private fun getOperatorByStringValue(value: String): Operator {
            return when (value) {
                PLUS.stringValue -> PLUS
                MINUS.stringValue -> MINUS
                DIVIDE.stringValue -> DIVIDE
                MULTIPLY.stringValue -> MULTIPLY
                else -> throw IllegalArgumentException(WRONG_OPERATOR_ERROR_MSG)
            }
        }

        fun isValidOperator(operator: String): Boolean {
            return values().any { it.stringValue == operator }
        }

        fun getCalculateLogic(operator: String): (a: Double, b: Double) -> Double {
            return getOperatorByStringValue(operator).calcLogic
        }
    }
}
