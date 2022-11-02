package string_calculator

import java.lang.IllegalArgumentException
import java.util.function.BiFunction

enum class Operator(val operator: String, val calculation: BiFunction<Int, Int, Int>) {
    PLUS("+", BiFunction { a, b -> a + b }),
    MINUS("-", BiFunction { a, b -> a - b }),
    MULTIPLY("*", BiFunction { a, b -> a * b }),
    DIVIDE("/", BiFunction { a, b -> a / b });

    companion object {
        @JvmStatic
        fun calculate(a: Int, b: Int, operator: String): Int =
            values()
                .firstOrNull() { it.operator == operator }
                ?.calculation?.apply(a, b)
                ?: throw IllegalArgumentException()
    }
}
