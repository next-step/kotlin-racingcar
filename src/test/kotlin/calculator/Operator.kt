package calculator

enum class Operator(val stringValue: String) {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    companion object {
        fun getOperatorByStringValue(value: String): Operator {
            return when (value) {
                PLUS.stringValue -> PLUS
                MINUS.stringValue -> MINUS
                DIVIDE.stringValue -> DIVIDE
                MULTIPLY.stringValue -> MULTIPLY
                else -> throw IllegalArgumentException(StringCalculator.WRONG_OPERATOR_ERROR_MSG)
            }
        }

        fun isValidOperator(operator: String): Boolean {
            return values().any { it.stringValue == operator }
        }
    }
}