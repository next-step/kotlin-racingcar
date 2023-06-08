package step2

enum class Operator(
    val operator: String
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun calculate(prev: Double, next: Double, operator: Operator): Double {
            return when (operator) {
                PLUS -> prev + next
                MINUS -> prev - next
                MULTIPLY -> prev * next
                DIVIDE -> prev / next
            }
        }

        fun getOperator(value: String): Operator {
            return Operator.values().find { it.operator == value }
                ?: throw IllegalArgumentException("올바른 연산자가 아닙니다.")
        }
    }
}
