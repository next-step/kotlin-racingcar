package calculator

private const val DOUBLE_ZERO = 0.0

enum class Operator(private val value: String, private val function: (Double, Double) -> Double) {
    PLUS("+", { first, second -> first + second }),
    MINUS("-", { first, second -> first - second }),
    DIVISION("/", { first, second ->
        require(second != DOUBLE_ZERO) { "0으로 나눌수 없습니다." }
        first / second
    }),
    TIMES("*", { first, second -> first * second });

    companion object {
        fun find(operator: String): Operator {
            return values().firstOrNull { it.value == operator }
                ?: throw IllegalArgumentException("사칙연산 기호가 올바르지 않습니다.")
        }
    }

    fun operate(first: Double, second: Double): Double {
        return function(first, second)
    }
}
