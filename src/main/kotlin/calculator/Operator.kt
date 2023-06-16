package calculator

enum class Operator(
    val operator: String,
    val operation: (x: Double, y: Double) -> Double
) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    fun calculate(prev: Double, next: Double): Double {
        return this.operation(prev, next)
    }

    companion object {

        fun getOperator(value: String): Operator {
            return Operator.values().find { it.operator == value }
                ?: throw IllegalArgumentException("올바른 연산자가 아닙니다.")
        }
    }
}
