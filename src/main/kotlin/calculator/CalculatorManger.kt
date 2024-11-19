package calculator

import calculator.util.getValidateInputOrThrow

class CalculatorManger {
    fun start(input: String?): Double {
        val splitFormula = parseToValidInput(input)
        val startValue = 0.0
        val calculator = Calculator(startValue)
        return calculator.execute(splitFormula)
    }

    fun parseToValidInput(input: String?): List<String> {
        val formula = input.getValidateInputOrThrow()
        val splitFormula = splitToNumbersAndOperators(formula)
        validateInput(splitFormula)
        return splitFormula
    }

    fun validateInput(input: List<String>) {
        if (input.size % 2 == 0) throw IllegalArgumentException("Invalid Input")
    }

    fun splitToNumbersAndOperators(input: String): List<String> {
        val delimiter = " "
        return input.split(delimiter).toList()
    }
}
