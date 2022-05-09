package calculator

import java.util.function.BiFunction

enum class Operator(
    private val type: String,
    private val expression: BiFunction<Int, Int, Any>
) {
    PLUS("*", BiFunction { a: Int, b: Int -> a + b });

    fun cal(a: Int, b: Int): Any {
        return expression.apply(a, b)
    }
}
