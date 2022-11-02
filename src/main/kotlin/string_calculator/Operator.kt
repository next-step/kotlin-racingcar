package string_calculator

import java.util.function.BiFunction

enum class Operator(val operator: String, val calculation: BiFunction<Int, Int, Int>) {
    PLUS("+", BiFunction { a, b -> a + b }),
    MINUS("-", BiFunction { a, b -> a - b }),
    MULTIPLY("*", BiFunction { a, b -> a * b }),
    DIVIDE("/", BiFunction { a, b -> a / b });
}
