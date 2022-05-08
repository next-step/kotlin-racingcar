package calculator

private const val DOUBLE_ZERO = 0.0

enum class Operator(private val value: String, private val function: (Double, Double) -> Double) {
    PLUS("+", { t, u -> t + u }),
    MINUS("-", { t, u -> t - u }),
    DIVISION("/", { t, u ->
        require(u != DOUBLE_ZERO) { "0으로 나눌수 없습니다." }
        t / u
    }),
    TIMES("*", { t, u -> t * u });

    companion object {
        fun find(operator: String): Operator {
            return values().firstOrNull { it.value == operator }
                ?: throw IllegalArgumentException("사칙연산 기호가 올바르지 않습니다.")
        }
    }

    fun operate(first: Double, second: Double): Double {
        return function.invoke(first, second)
    }
}
