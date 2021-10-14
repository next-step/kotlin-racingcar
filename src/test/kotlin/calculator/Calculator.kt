package calculator

import calculator.CalculatorResources.Companion.DELIMITER
import calculator.CalculatorResources.Companion.IS_NOT_OR_BLANK
import java.util.ArrayList

class Calculator {

    private fun calculate(input: String) {

        checkNullOrEmpty(input)
        
    }

    private fun checkNullOrEmpty(input: String) {
        if (input?.isNullOrEmpty()) {
            throw IllegalArgumentException(IS_NOT_OR_BLANK)
        }
    }

    private fun splitInputStr(input: String): List<String> = input.split(DELIMITER)
    
    private fun doPlus(a: Int, b: Int): Int = a + b
    private fun doMinus(a: Int, b: Int): Int = a - b
    private fun doMultiply(a: Int, b: Int): Int = a * b
    private fun doDivision(a: Int, b: Int): Int = a / b
}
