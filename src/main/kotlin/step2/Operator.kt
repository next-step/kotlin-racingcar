package step2

enum class Operator(
    val operator: String,
    val operation: (x: Double, y: Double) -> Double
) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        fun calculate(prev: Double, next: Double, operator: Operator): Double {
            return operator.operation(prev, next)
        }

        fun getOperator(value: String): Operator {
            return Operator.values().find { it.operator == value }
                ?: throw IllegalArgumentException("올바른 연산자가 아닙니다.")
        }
    }
}
