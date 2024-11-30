package calculator

import kotlin.math.floor

enum class Calculator(val symbol: String, val execute: (Int, Int) -> Int) {
    ADD("+", { number1, number2 -> number1 + number2 }),
    SUBSTRACT("-", { number1, number2 -> number1 - number2 }),
    MULTIPLY("*", { number1, number2 -> number1 * number2 }),
    DEVIDE("/", { number1, number2 -> floor(number1.toDouble() / number2).toInt() }),
    ;

    companion object {
        fun calculate(
            calculation: String,
            firstOperand: Int,
            secondOperand: Int,
        ): Int {
            for (calculator in entries) {
                if (calculator.symbol == calculation) {
                    return calculator.execute(firstOperand, secondOperand)
                }
            }
            throw IllegalArgumentException()
        }
    }
}
