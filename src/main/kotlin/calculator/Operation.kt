package calculator

import java.lang.IllegalArgumentException
import java.util.function.BiFunction

enum class Operation(val char: String, val operate: BiFunction<Int, Int, Int>) {
    PLUS("+", BiFunction { first: Int, second: Int -> first + second }),
    MINUS("-", BiFunction { first: Int, second: Int -> first - second }),
    MULTIPLE("*", BiFunction { first: Int, second: Int -> first * second }),
    DIVIDE("/", BiFunction { first: Int, second: Int -> first / second });

    fun calc(first: Int, second: Int): Int {
        return operate.apply(first, second)
    }

    companion object {
        @JvmStatic
        fun operationOf(operation: String): Operation {
            return values().firstOrNull { item -> item.char == operation } ?: throw IllegalArgumentException()
        }
    }
}
