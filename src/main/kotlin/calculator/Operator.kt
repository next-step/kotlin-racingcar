package calculator

import java.util.function.BiFunction

enum class Operator(private val operation: BiFunction<Double, Double, Double>) {
    PLUS({ a, b -> a + b }),
    MINUS({ a, b -> a - b }),
    MULTIPLY({ a, b -> a * b }),
    DIVIDE({ a, b -> a / b })
    ;

    fun calculate(a: Double, b: Double): Double {
        return operation.apply(a, b)
    }

    companion object {
        fun findBy(symbol: String): Operator {
            return when (symbol) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> throw IllegalArgumentException("지원하지 않는 연산자입니다. symbol: $symbol")
            }
        }
    }
}
