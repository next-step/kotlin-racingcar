package week1.calculator

import java.util.function.BinaryOperator

enum class Operator(private val symbol: String) : BinaryOperator<Int> {
    PLUS(symbol = "+") {
        override fun apply(
            t: Int,
            u: Int,
        ): Int = t + u
    },
    MINUS(symbol = "-") {
        override fun apply(
            t: Int,
            u: Int,
        ): Int = t - u
    },
    DIVIDE(symbol = "/") {
        override fun apply(
            t: Int,
            u: Int,
        ): Int = t / u
    },
    MULTIPLY(symbol = "*") {
        override fun apply(
            t: Int,
            u: Int,
        ): Int = t * u
    }, ;

    companion object {
        fun from(input: String): Operator {
            return Operator.entries.find { it.symbol == input }
                ?: throw IllegalArgumentException("Invalid Operator $input")
        }
    }
}
