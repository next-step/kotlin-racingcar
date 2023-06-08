package step2

enum class Operator(
    private val operator: String
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun isOperator(value: String): Boolean {
            val operators = Operator.values().map { it.operator }
            return operators.contains(value)
        }

        fun getOperator(value: String): Operator {
            return Operator.values().find { it.operator == value }
                ?: throw IllegalArgumentException("올바른 연산자가 아닙니다.")
        }
    }
}
