package stringcalculator

import java.util.function.BinaryOperator

enum class Operator(
    private val keyword: String,
    private val delegate: BinaryOperator<Double>
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    DIVIDE("/", { a, b -> a / b }),
    MULTIPLY("*", { a, b -> a * b });

    operator fun invoke(first: Double, second: Double): Double {
        return delegate.apply(first, second)
    }

    companion object {
        fun find(keyword: String): Operator {
            return values().find { it.keyword == keyword } ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }
}
