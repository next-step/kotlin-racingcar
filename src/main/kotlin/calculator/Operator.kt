package calculator

import java.util.function.BinaryOperator

enum class Operator(val sign: String) : BinaryOperator<Int> {
    PLUS("+") {
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

    companion object {
        fun contain(sign: String): Boolean {
            return values().any { it.sign == sign }
        }

        fun bySign(sign: String): Operator {
            return values().firstOrNull { it.sign == sign } ?: throw IllegalArgumentException("$sign is not operator.")
        }
    }
}
