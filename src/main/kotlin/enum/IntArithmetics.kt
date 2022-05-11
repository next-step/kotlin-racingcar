package enum

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class IntArithmetics(val operator: String) : BinaryOperator<Int>, IntBinaryOperator {
    PLUS("+") {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    MULTIPLE("*") {
        override fun apply(t: Int, u: Int): Int = t * u
    },
    MINUS("-") {
        override fun apply(t: Int, u: Int): Int = t - u
    },
    DIVIDE("/") {
        override fun apply(t: Int, u: Int): Int = t / u
    };
    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}
