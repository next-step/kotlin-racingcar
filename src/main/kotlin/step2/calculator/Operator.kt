package step2.calculator

import java.util.function.BiFunction

enum class Operator(
    private val symbol: String,
    private val function: BiFunction<Long, Long, Long>
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDED("/", { a, b -> a / b })
    ;

    fun operate(first: Long, second: Long): Long {
        return function.apply(first, second)
    }

    companion object {
        fun getOperator(symbol: String): Operator {
            val matched = values().firstOrNull { it.symbol == symbol }
            if (matched != null) {
                return matched
            }
            throw IllegalArgumentException("해당 연산자를 찾을 수 없습니다. `${symbol}`")
        }
    }
}