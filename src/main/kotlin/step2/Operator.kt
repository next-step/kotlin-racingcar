package step2

import java.util.function.BiFunction

enum class Operator(val value: String) : BiFunction<Int, Int, Int> {
    PLUS("+") {
        override fun apply(t: Int, u: Int): Int = t + u
    },

    MINUS("-") {
        override fun apply(t: Int, u: Int): Int = t - u
    },

    MULTIPLY("*") {
        override fun apply(t: Int, u: Int): Int = t * u
    },

    DIVIDE("/") {
        override fun apply(t: Int, u: Int): Int = t / u
    };

    companion object {
        private val operators = Operator.values().associateBy(Operator::value)
        fun from(value: String) = operators[value]
    }
}
