package calculator

import calculator.CalculatorResources.Companion.DELIMITER
import calculator.CalculatorResources.Companion.IS_NOT_OR_BLANK
import calculator.CalculatorResources.Companion.SYMBOL_NOT_RIGHT

class Calculator {

    fun calculate(input: String?): Int {

        validateNullOrEmpty(input)

        val splitStrings = splitInputStr(input!!)
        var result: Int = splitStrings[0].toInt()

        splitStrings.forEachIndexed { i, _ ->
            if (i % 2 == 1) {
                val param = splitStrings[i + 1].toInt()
                result = when (splitStrings[i]) {
                    CalculatorResources.PLUS -> doPlus(result, param)
                    CalculatorResources.MINUS -> doMinus(result, param)
                    CalculatorResources.MULTIPLY -> doMultiply(result, param)
                    CalculatorResources.DIVISION -> doDivision(result, param)
                    else -> {
                        throw IllegalArgumentException(SYMBOL_NOT_RIGHT)
                    }
                }
            }
        }
        return result
    }

    private fun validateNullOrEmpty(input: String?) {
        if (input?.trim().isNullOrEmpty()) {
            throw IllegalArgumentException(IS_NOT_OR_BLANK)
        }
    }

    private fun splitInputStr(input: String): List<String> = input.split(DELIMITER)

    private fun doPlus(a: Int, b: Int) = a + b
    private fun doMinus(a: Int, b: Int) = a - b
    private fun doMultiply(a: Int, b: Int) = a * b
    private fun doDivision(a: Int, b: Int) = a / b
}
