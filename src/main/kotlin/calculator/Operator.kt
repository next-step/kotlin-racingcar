package calculator

import java.util.function.BiFunction

enum class Operator(
    private val symbol: String,
    private val function: BiFunction<Int, Int, Int>
) {
    ADDITION("+", { first, second -> first + second }),
    SUBTRACTION("-", { first, second -> first - second }),
    MULTIPLICATION("*", { first, second -> first * second }),
    DIVISION("/", { first, second -> first / second });


    fun calculate(first: Int, second: Int): Int {
        return function.apply(first, second)
    }

    companion object {
        fun of(symbol: String): Operator {
            return Operator.values()
                .find { it.symbol == symbol }
                ?: throw java.lang.IllegalArgumentException("{$symbol}에 일치하는 연산자가 존재하지 않습니다.")
        }
    }

}
