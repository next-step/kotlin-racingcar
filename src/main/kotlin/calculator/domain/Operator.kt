package calculator.calculator.domain

import java.util.function.BiFunction

enum class Operator(private val symbol: String, private val operate: BiFunction<Double, Double, Double>) {
    ADD("+", { prev: Double, next: Double -> prev + next }),
    SUB("-", { prev: Double, next: Double -> prev - next }),
    MUL("*", { prev: Double, next: Double -> prev * next }),
    DIV("/", { prev: Double, next: Double -> prev / next });

    companion object {
        fun from(symbol: String): Operator {
            require(values().any { operator -> operator.symbol == symbol }) { "존재하지 않는 기호입니다." }
            return values().first { operator -> operator.symbol == symbol }
        }
    }

    fun calculate(prev: Double, next: Double): Double {
        return operate.apply(prev, next)
    }
}
