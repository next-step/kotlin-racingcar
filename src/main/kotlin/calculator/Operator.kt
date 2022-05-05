package calculator

import java.util.function.BiFunction

enum class Operator(
    private val execute: BiFunction<Int, Int, Int>
) {
    PLUS(BiFunction { a: Int, b: Int -> a + b }),
    MINUS(BiFunction { a: Int, b: Int -> a - b }),
    MULTIPLY(BiFunction { a: Int, b: Int -> a * b }),
    DIVIDE(BiFunction { a: Int, b: Int -> a / b }),
    ;

    fun operate(a: Int, b: Int): Int = execute.apply(a, b)
}
