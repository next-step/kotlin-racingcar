package calculator

import java.lang.IllegalArgumentException

enum class Calculator(val symbol: String) {
    ADD("+") {
        override fun operation(a: Int, b: Int): Int = a + b
    },
    SUBTRACT("-") {
        override fun operation(a: Int, b: Int): Int = a - b
    },
    MULTIPLY("*") {
        override fun operation(a: Int, b: Int): Int = a * b
    },
    DIVIDE("/") {
        override fun operation(a: Int, b: Int): Int = a / b
    };

    abstract fun operation(a: Int, b: Int): Int

    companion object {
        private val map = Calculator.values().associateBy { it.symbol }
        operator fun get(symbol: String): Calculator {
            return map[symbol] ?: throw IllegalArgumentException("Invalid operator : $symbol")
        }
    }
}
