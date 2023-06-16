package calculator

import calculator.CalculatorValidator.isNumber
import calculator.CalculatorValidator.isOperator
import calculator.CalculatorValidator.validateIsNumberOrOperator
import calculator.CalculatorValidator.validateRegex
import calculator.Operator.Companion.getOperator

class StringCalculator {

    fun execute(formula: String): Double {
        require(formula.isNotEmpty() && formula.isNotBlank())
        validateRegex(formula)

        val values = formula.split(" ")
        var result = values[0].toDouble()
        lateinit var operator: Operator

        for (i in 1 until values.size) {
            val value = values[i]
            validateIsNumberOrOperator(value)

            if (isOperator(value)) {
                operator = getOperator(value)
            }
            if (isNumber(value)) {
                result = operator.calculate(prev = result, next = value.toDouble())
            }
        }

        return result
    }
}
