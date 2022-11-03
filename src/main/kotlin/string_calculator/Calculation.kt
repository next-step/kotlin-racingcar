package string_calculator

import java.util.function.BiFunction

enum class Calculation(val operator: Char, val calculation: BiFunction<Int, Int, Int>) {
    PLUS('+', BiFunction { a, b -> a + b }),
    MINUS('-', BiFunction { a, b -> a - b }),
    MULTIPLY('*', BiFunction { a, b -> a * b }),
    DIVIDE('/', BiFunction { a, b -> a / b });

    companion object {
        @JvmStatic
        fun isValid(operator: Char): Boolean {
            return operator in values().map { it.operator }
        }

        @JvmStatic
        fun calculate(a: Int, b: Int, operator: Char): Int =
            values()
                .first() { it.operator == operator }
                .calculation.apply(a, b)
    }
}
