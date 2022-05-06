package calculator

import java.util.function.BinaryOperator

enum class Operator(private val value: String, private val apply: BinaryOperator<Double>) {
    PLUS("+", { t, u -> t + u }),
    MINUS("-", { t, u -> t - u }),
    DIVISION("/", { t, u -> t / u }),
    TIMES("*", { t, u -> t * u });

    companion object {
        fun find(operator: String): Operator {
            return values().firstOrNull { it.value == operator } ?: throw IllegalArgumentException("사칙연산 기호가 올바르지 않습니다.")
        }
    }

    fun operate(first: Double, second: Double): Double {
        return apply.apply(first, second)
    }
}
