package step2

import java.lang.IllegalArgumentException

class CalculatorImpl : Calculator {
    override fun plus(first: Int, second: Int): Int {
        return first + second
    }

    override fun minus(first: Int, second: Int): Int {
        return first - second
    }

    override fun divide(first: Int, second: Int): Int {
        return first / second
    }

    override fun multiply(first: Int, second: Int): Int {
        return first * second
    }

    fun calculate(first: Int, symbol: String, second: Int) = when (symbol) {
        "+" -> plus(first, second)
        "-" -> minus(first, second)
        "*" -> multiply(first, second)
        "/" -> divide(first, second)
        else -> throw IllegalArgumentException()
    }

    fun checkSymbol(symbol: String): Boolean = when (symbol) {
        "+", "-", "*", "/" -> true
        else -> throw IllegalArgumentException()
    }

    fun calculateString(input: String?): Int {
        val inputs = input?.split(" ") ?: throw IllegalArgumentException()
        var flag = true
        var result = inputs[0].toInt()
        var symbol = ""

        inputs.drop(1).forEach {
            if (flag && checkSymbol(it)) {
                symbol = it
            } else {
                result = calculate(result, symbol, it.toInt())
            }
            flag = !flag
        }
        return result
    }
}
