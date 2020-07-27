package calculator

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class Operator(val operator: String) : BinaryOperator<Int>, IntBinaryOperator {
    ADD("+") {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    MINUS("-") {
        override fun apply(t: Int, u: Int): Int = t - u
    },
    TIMES("*") {
        override fun apply(t: Int, u: Int): Int = t * u
    },
    DIVIDE("/") {
        override fun apply(t: Int, u: Int): Int = t / u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}
