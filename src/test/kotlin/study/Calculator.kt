package study

import study.ArithMeticSymbol.DIVIDE
import study.ArithMeticSymbol.MINUS
import study.ArithMeticSymbol.MULTIPLY
import study.ArithMeticSymbol.PLUS

class Calculator(val input: String?) {
    fun calculate(): Double {
        val inputValues = input?.split(" ") ?: throw IllegalArgumentException("입력값이 null 입니다.")

        checkInputValid(inputValues)

        var current = runCatching { inputValues[0].toDouble() }.getOrElse { throw IllegalArgumentException() }
        var arithMeticSymbol: ArithMeticSymbol? = null
        for (inputValue in inputValues.subList(1, inputValues.size)) {
            if (inputValue.isNumeric()) {
                current = when (arithMeticSymbol) {
                    PLUS -> plus(current, inputValue.toDouble())
                    MINUS -> minus(current, inputValue.toDouble())
                    DIVIDE -> divide(current, inputValue.toDouble())
                    MULTIPLY -> multiply(current, inputValue.toDouble())
                    else -> throw IllegalArgumentException()
                }
            }
            arithMeticSymbol = ArithMeticSymbol.of(inputValue)
        }
        return current
    }

    private fun plus(value1: Double, value2: Double) = value1 + value2

    private fun minus(value1: Double, value2: Double) = value1 - value2

    private fun divide(value1: Double, value2: Double) = value1 / value2

    private fun multiply(value1: Double, value2: Double) = value1 * value2

    private fun checkInputValid(inputValues: List<String>) {
        if (inputValues.size < 3) {
            throw IllegalArgumentException()
        }
    }
}

private enum class ArithMeticSymbol(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*"), ;

    companion object {
        fun of(symbol: String): ArithMeticSymbol {
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException()
        }
    }
}

private fun String.isNumeric(): Boolean {
    return this.all { char -> char.isDigit() }
}
