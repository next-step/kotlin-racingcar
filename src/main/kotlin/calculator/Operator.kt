package calculator

import calculator.exception.IllegalSymbolException
import java.util.function.BiFunction

enum class Operator(val symbol: String, private val operatorFunction: BiFunction<Float, Float, Float>) {
    ADD("+", { x, y -> x + y }),
    SUBTRACT("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y ->
        if (y == 0F) {
            throw calculator.exception.DivideByZeroException()
        }
        x / y
    });

    fun calculate(x: Float, y: Float): Float {
        return operatorFunction.apply(x, y)
    }

    companion object {
        fun findBySymbol(symbol: String): Operator {
            return values().find { symbol == it.symbol } ?: throw IllegalSymbolException(symbol)
        }

        fun isOperatorSymbol(symbol: String): Boolean {
            return values().any { it.symbol == symbol }
        }
    }
}
