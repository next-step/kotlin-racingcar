package com.jay.calculator

import java.lang.IllegalArgumentException
import java.util.function.BinaryOperator

enum class Operand(val symbol: String) : BinaryOperator<Int> {
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
        override fun apply(t: Int, u: Int): Int {
            require(u != 0) { "cannot divide into zero" }
            return t / u
        }
    };

    companion object {
        fun symbolOf(symbol: String): Operand {
            return Operand.values().firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("invalid operand - $symbol")
        }
    }
}
